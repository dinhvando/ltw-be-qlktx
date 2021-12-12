package dodv.dormitorymanagement.demo.controller;

import dodv.dormitorymanagement.demo.dto.request.VisitRequestDTO;
import dodv.dormitorymanagement.demo.dto.response.VisitDTO;
import dodv.dormitorymanagement.demo.dto.response.VisitorDTO;
import dodv.dormitorymanagement.demo.service.VisitService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visit/")
@Transactional
@Log4j2
public class VisitController {
    @Autowired
    VisitService visitService;
    @GetMapping("/get-visit-history")
    public List<VisitDTO> getAllVisitHistory(){
        return visitService.getAllVisits();
    }
    @PostMapping("/create-visit")
    public void createVisit(@RequestBody VisitRequestDTO visitRequest){
        visitService.createVisit(visitRequest);
    }
}
