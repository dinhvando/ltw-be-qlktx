package dodv.dormitorymanagement.demo.repository;

import dodv.dormitorymanagement.demo.entity.Bill;
import dodv.dormitorymanagement.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    @Query(value = "SELECT b from Bill b WHERE b.student = ?1 AND b.time = ?2")
    List<Bill> getAllBillsByStudentAndTime(Student student, Date time);

}
