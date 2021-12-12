package dodv.dormitorymanagement.demo.service;

import dodv.dormitorymanagement.demo.dto.response.ClassDTO;
import dodv.dormitorymanagement.demo.entity.Class;
import dodv.dormitorymanagement.demo.repository.ClassRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@Log4j2
public class ClassService {
    @Autowired
    private ClassRepository classRepository;
    public List<ClassDTO> getAllClasses () {
        List<ClassDTO> result = new LinkedList<>();
        List<Class> classList =  classRepository.findAll();
        for(Class x: classList){
            result.add(ClassDTO.builder().classID(x.getId()).className(x.getName()).build());
        }
        return result;
    }
}
