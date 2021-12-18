package dodv.dormitorymanagement.demo.repository;

import dodv.dormitorymanagement.demo.entity.Student;
import dodv.dormitorymanagement.demo.entity.StudentLaundry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface LaundryServiceRepository extends JpaRepository<StudentLaundry, Integer> {
        @Query(value = "Select s from  StudentLaundry s where s.student = ?1 and s.time = ?2")
        List<StudentLaundry> getLaundryServiceByStudentAndTime(Student student, Date time);
}
