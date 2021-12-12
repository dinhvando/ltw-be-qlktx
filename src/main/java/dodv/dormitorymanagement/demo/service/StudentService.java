package dodv.dormitorymanagement.demo.service;

import dodv.dormitorymanagement.demo.dto.response.ClassDTO;
import dodv.dormitorymanagement.demo.dto.response.StudentDTO;
import dodv.dormitorymanagement.demo.entity.Student;
import dodv.dormitorymanagement.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

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
                    .build();
        }
      return res;
    }
}
