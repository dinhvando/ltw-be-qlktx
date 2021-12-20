package dodv.dormitorymanagement.demo.controller;

import dodv.dormitorymanagement.demo.dto.response.ClassDTO;
import dodv.dormitorymanagement.demo.service.ClassService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/class/")
public class ClassController {
    @Autowired
    private ClassService classService;
    @GetMapping("/get-all-classes")
    public List<ClassDTO> getAllClasses(){
        return classService.getAllClasses();
    }
}
