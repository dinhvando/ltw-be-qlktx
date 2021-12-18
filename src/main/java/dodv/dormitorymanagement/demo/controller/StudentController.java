package dodv.dormitorymanagement.demo.controller;

import dodv.dormitorymanagement.demo.dto.request.FoodServiceRequestDTO;
import dodv.dormitorymanagement.demo.dto.request.LaundryServiceRequestDTO;
import dodv.dormitorymanagement.demo.dto.request.StudentRequestDTO;
import dodv.dormitorymanagement.demo.dto.response.StudentDTO;
import dodv.dormitorymanagement.demo.service.StudentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/")
@Transactional
@Log4j2
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



}
