package dodv.dormitorymanagement.demo.controller;

import dodv.dormitorymanagement.demo.dto.request.VisitorRequestDTO;
import dodv.dormitorymanagement.demo.dto.response.VisitorDTO;
import dodv.dormitorymanagement.demo.service.VisitorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitor/")
public class VisitorController {
    @Autowired
    VisitorService visitorService;
    @GetMapping("/get-all-visitors")
    public List<VisitorDTO> getAllVisitors(){
        return visitorService.getAllVisitors();
    }
    @PostMapping("/create-visitor")
    public void createVisitor(@RequestBody VisitorRequestDTO visitorRequest){
        visitorService.createVisitor(visitorRequest);
    }
}
