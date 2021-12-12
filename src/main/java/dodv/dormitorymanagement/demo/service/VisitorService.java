package dodv.dormitorymanagement.demo.service;

import dodv.dormitorymanagement.demo.dto.request.VisitorRequestDTO;
import dodv.dormitorymanagement.demo.dto.response.VisitorDTO;
import dodv.dormitorymanagement.demo.entity.Visitor;
import dodv.dormitorymanagement.demo.repository.VisitorRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class VisitorService {
    @Autowired
    VisitorRepository visitorRepository;
    public List<VisitorDTO> getAllVisitors(){
        List<VisitorDTO> result = new LinkedList<>();
        List<Visitor> visitorList =  visitorRepository.findAll();
        for(Visitor x: visitorList){
            result.add(VisitorDTO.builder().visitorIdCard(x.getVisitorId()).name(x.getName()).build());
        }
        return result;
    }

    public void createVisitor(@NotNull VisitorRequestDTO visitorRequest) {
        visitorRepository.save(new Visitor(visitorRequest.getVisitorIdCard(), visitorRequest.getName()));
    }
}
