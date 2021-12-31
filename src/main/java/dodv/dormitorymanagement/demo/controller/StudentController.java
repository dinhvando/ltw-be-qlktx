package dodv.dormitorymanagement.demo.controller;

import dodv.dormitorymanagement.demo.dto.request.FoodServiceRequestDTO;
import dodv.dormitorymanagement.demo.dto.request.LaundryServiceRequestDTO;
import dodv.dormitorymanagement.demo.dto.request.StudentRequestDTO;
import dodv.dormitorymanagement.demo.dto.response.StudentDTO;
import dodv.dormitorymanagement.demo.entity.ViewStudentBillDetail;
import dodv.dormitorymanagement.demo.service.StudentService;
import dodv.dormitorymanagement.demo.utils.UserUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/student/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/get-all-students")
    public List<StudentDTO> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/get-student-details/{id}")
    public StudentDTO getStudentByID(@PathVariable String id){
        return studentService.getStudentByID(id);
    }

    @PostMapping("/create-student")
    public void createStudent(@RequestBody StudentRequestDTO studentRequest){
        studentService.createStudent(studentRequest);
    }
    @PostMapping("/insert-laundry-service")
    public void insertLaundryService(@RequestBody LaundryServiceRequestDTO inputLaundryRequest){
            studentService.insertLaundryService(inputLaundryRequest);
    }
    @PostMapping("/insert-food-service")
    public void insertFoodService(@RequestBody FoodServiceRequestDTO inputFoodRequest){
            studentService.insertFoodService(inputFoodRequest);
    }
    @GetMapping("/student-by-room/{roomID}")
    public List<StudentDTO> getStudentsByRooms(@PathVariable Integer roomID){
            return studentService.getStudentsByRooms(roomID);
    }

    @GetMapping("/view-student-bill-detail")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public ViewStudentBillDetail getStudentBillDetails(@RequestParam String studentID, @RequestParam Date time) {
        return studentService.getBillDetailsByStudentAndTime(studentID, time);
    }
    @GetMapping("view-all-student-bill-detail/{studentID}")
    public List<ViewStudentBillDetail> getAllStudentBillDetails(@PathVariable String studentID){
        return studentService.getALlBillDetailByStudent(studentID);
    }
    @GetMapping("/get-my-info")
    public StudentDTO getMyInfo(){
        return studentService.getMyInfo();
    }


}
