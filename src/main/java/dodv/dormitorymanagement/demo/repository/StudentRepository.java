package dodv.dormitorymanagement.demo.repository;

import dodv.dormitorymanagement.demo.dto.response.StudentBillDetailsDTO;
import dodv.dormitorymanagement.demo.entity.Bill;
import dodv.dormitorymanagement.demo.entity.Room;
import dodv.dormitorymanagement.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    Long countStudentByRoom(Room room);
    List<Student> getStudentByRoom(Room room);


}
