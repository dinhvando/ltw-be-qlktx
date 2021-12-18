package dodv.dormitorymanagement.demo.repository;

import dodv.dormitorymanagement.demo.entity.Student;
import dodv.dormitorymanagement.demo.entity.StudentFood;
import dodv.dormitorymanagement.demo.service.FoodService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface FoodServiceRepository extends JpaRepository<StudentFood, Integer> {
    @Query(value = "Select s from  StudentFood s where s.student = ?1 and s.time = ?2")
    List<StudentFood> getFoodServiceByStudentAndTime(Student student, Date time);
}
