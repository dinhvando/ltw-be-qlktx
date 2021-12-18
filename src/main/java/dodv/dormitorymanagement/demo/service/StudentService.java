package dodv.dormitorymanagement.demo.service;

import dodv.dormitorymanagement.demo.dto.request.FoodServiceRequestDTO;
import dodv.dormitorymanagement.demo.dto.request.LaundryServiceRequestDTO;
import dodv.dormitorymanagement.demo.dto.request.StudentRequestDTO;
import dodv.dormitorymanagement.demo.dto.response.ClassDTO;
import dodv.dormitorymanagement.demo.dto.response.StudentDTO;
import dodv.dormitorymanagement.demo.entity.*;
import dodv.dormitorymanagement.demo.entity.Class;
import dodv.dormitorymanagement.demo.repository.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ClassRepository classRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    LaundryServiceRepository laundryServiceRepository;
    @Autowired
    FoodServiceRepository foodServiceRepository;
    @Autowired
    BillRepository billRepository;
    @Autowired
    FoodRepository foodRepository;
    public List<StudentDTO> getAllStudents(){
        List<StudentDTO> result = new LinkedList<>();
        List<Student> studentList =  studentRepository.findAll();
        for(Student x: studentList){
            result.add(StudentDTO.builder()
                    .studentID(x.getStudentID())
                    .name(x.getName())
                    .address(x.getAddress())
                    .dateOfBirth(x.getDateOfBirth())
                    .image(x.getImage())
                    .studentClass(new ClassDTO(x.getClassName().getId(),x.getClassName().getName()))
                    .build()
            );
        }
        return result;
    }
    public StudentDTO getStudentByID(String id){
        StudentDTO res = null;
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            Student realStudent = student.get();
          res =  StudentDTO.builder()
                    .studentID(realStudent.getStudentID())
                    .name(realStudent.getName())
                    .address(realStudent.getAddress())
                    .dateOfBirth(realStudent.getDateOfBirth())
                    .image(realStudent.getImage())
                    .studentClass(new ClassDTO(realStudent.getClassName().getId(),realStudent.getClassName().getName()))
                    .roomName(realStudent.getRoom().getName())
                    .build();
        }
      return res;
    }

    public void createStudent(@NotNull StudentRequestDTO studentRequest) {
        Optional<Class> addedClass = classRepository.findById(studentRequest.getClassID());
        Optional<Room> addedRoom = roomRepository.findById(studentRequest.getRoomID());
        if(addedRoom.isPresent() && addedRoom.isPresent()){
            studentRepository.save(new Student(
                    studentRequest.getStudentID(),
                    studentRequest.getName(),
                    studentRequest.getAddress(),
                    studentRequest.getDateOfBirth(),
                    studentRequest.getImage(),
                    addedClass.get(),
                    addedRoom.get()
                    ));
        }

    }
    @Transactional
    public void insertLaundryService(@NotNull LaundryServiceRequestDTO laundryService){
      Student student = studentRepository.getById(laundryService.getStudentID());
        List<StudentLaundry> serviceList = laundryServiceRepository.getLaundryServiceByStudentAndTime(student, laundryService.getTime());
        if(serviceList.size() > 0){
            StudentLaundry x = serviceList.get(0);
            x.setStudent(student);
            x.setPrice(laundryService.getPrice());
            x.setTime(laundryService.getTime());
            laundryServiceRepository.saveAll(serviceList);
            List<Bill> studentInBill = billRepository.getAllBillsByStudentAndTime(student,laundryService.getTime());
            addLaundryBillFollowingStudent(studentInBill, x, laundryService.getTime(), student);
        }else{
            StudentLaundry addedLaundryService = new StudentLaundry();
            addedLaundryService.setStudent(student);
            addedLaundryService.setPrice(laundryService.getPrice());
            addedLaundryService.setTime(laundryService.getTime());
            laundryServiceRepository.save(addedLaundryService);
            List<Bill> studentInBill = billRepository.getAllBillsByStudentAndTime(student,laundryService.getTime());
            addLaundryBillFollowingStudent(studentInBill, addedLaundryService, laundryService.getTime(), student);
        }

    }
    @Transactional
    public void insertFoodService(@NotNull FoodServiceRequestDTO inputFoodRequest) {
        Student student = studentRepository.getById(inputFoodRequest.getStudentID());
        Food pickedFood = foodRepository.findById(inputFoodRequest.getFoodID()).get();
        List<StudentFood> serviceList = foodServiceRepository.getFoodServiceByStudentAndTime(student, inputFoodRequest.getTime());
        if(serviceList.size() > 0){
            StudentFood x = serviceList.get(0);
            x.setStudent(student);
            x.setFood(pickedFood);
            x.setTime(inputFoodRequest.getTime());
            x.setTotalDay(inputFoodRequest.getTotalDay());
            foodServiceRepository.saveAll(serviceList);
            List<Bill> studentInBill = billRepository.getAllBillsByStudentAndTime(student,inputFoodRequest.getTime());
            addFoodBillFollowingStudent(studentInBill, x, inputFoodRequest.getTime(), student);
        }else{
            StudentFood addedStudentFood = new StudentFood();
            addedStudentFood.setStudent(student);
            addedStudentFood.setFood(pickedFood);
            addedStudentFood.setTime(inputFoodRequest.getTime());
            addedStudentFood.setTotalDay(inputFoodRequest.getTotalDay());
            foodServiceRepository.save(addedStudentFood);
            List<Bill> studentInBill = billRepository.getAllBillsByStudentAndTime(student,inputFoodRequest.getTime());
            addFoodBillFollowingStudent(studentInBill, addedStudentFood, inputFoodRequest.getTime(), student);
        }
    }

    private void addLaundryBillFollowingStudent(@NotNull List<Bill> bills, StudentLaundry studentLaundry, Date time, Student student){
        if(bills.size() > 0){
            Bill x = bills.get(0);
            x.setStudentLaundry(studentLaundry);
            billRepository.saveAll(bills);
        }else{
            Bill addedBill = new Bill();
            addedBill.setStudentLaundry(studentLaundry);
            addedBill.setTime(time);
            addedBill.setStudent(student);
            addedBill.setRoom(student.getRoom());
            billRepository.save(addedBill);
        }
    }
    private void addFoodBillFollowingStudent(@NotNull List<Bill> bills, StudentFood studentFood, Date time, Student student){
        if(bills.size() > 0){
            Bill x = bills.get(0);
            x.setStudentFood(studentFood);
            billRepository.saveAll(bills);
        }else{
            Bill addedBill = new Bill();
            addedBill.setStudentFood(studentFood);
            addedBill.setTime(time);
            addedBill.setStudent(student);
            addedBill.setRoom(student.getRoom());
            billRepository.save(addedBill);
        }
    }


}
