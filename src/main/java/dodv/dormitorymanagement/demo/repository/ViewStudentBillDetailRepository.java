package dodv.dormitorymanagement.demo.repository;

import dodv.dormitorymanagement.demo.entity.ViewStudentBillDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ViewStudentBillDetailRepository extends JpaRepository<ViewStudentBillDetail, String> {
    Optional<ViewStudentBillDetail> getFirstByStudentIdAndTime(String studentID, Date time);
    List<ViewStudentBillDetail> getByStudentId(String studentID);
}
