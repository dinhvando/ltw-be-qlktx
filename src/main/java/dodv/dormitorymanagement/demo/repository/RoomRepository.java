package dodv.dormitorymanagement.demo.repository;

import dodv.dormitorymanagement.demo.dto.response.Test;
import dodv.dormitorymanagement.demo.entity.Room;
import dodv.dormitorymanagement.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query(value = "Select m.students from Room m where m.id = ?1")
     List<Student> getAllStudents(Integer id);
}
