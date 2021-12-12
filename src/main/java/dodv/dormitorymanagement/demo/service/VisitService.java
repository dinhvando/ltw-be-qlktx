package dodv.dormitorymanagement.demo.service;

import dodv.dormitorymanagement.demo.dto.request.VisitRequestDTO;
import dodv.dormitorymanagement.demo.dto.response.VisitDTO;
import dodv.dormitorymanagement.demo.entity.Student;
import dodv.dormitorymanagement.demo.entity.Visit;
import dodv.dormitorymanagement.demo.entity.Visitor;
import dodv.dormitorymanagement.demo.repository.StudentRepository;
import dodv.dormitorymanagement.demo.repository.VisitRepository;
import dodv.dormitorymanagement.demo.repository.VisitorRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class VisitService {
    @Autowired
    VisitRepository visitRepository;
    @Autowired
    VisitorRepository visitorRepository;
    @Autowired
    StudentRepository studentRepository;
    public List<VisitDTO> getAllVisits(){
        List<VisitDTO> result = new LinkedList<>();
        List<Visit> visitHistory =  visitRepository.findAll();
        for(Visit x: visitHistory){
            result.add(VisitDTO.builder().id(x.getId()).studentName(x.getStudent().getName()).visitorName(x.getVisitor().getName()).time(x.getTime()).build());
        }
        return result;
    }

    public void createVisit(@NotNull VisitRequestDTO visitRequest){
        Visit visitAdded = new Visit();
       Optional<Visitor> visitorAdded = visitorRepository.findById(visitRequest.getVisitorID());
       Optional<Student> studentAdded = studentRepository.findById(visitRequest.getStudentID());
       if(visitorAdded.isPresent() && studentAdded.isPresent()){
           visitAdded.setVisitor(visitorAdded.get());
           visitAdded.setStudent(studentAdded.get());
           visitAdded.setTime(visitRequest.getTime());
           visitRepository.save(visitAdded);
       }

    }
}
