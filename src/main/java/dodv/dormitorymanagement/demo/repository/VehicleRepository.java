package dodv.dormitorymanagement.demo.repository;

import dodv.dormitorymanagement.demo.dto.response.StudentBillDetailsDTO;
import dodv.dormitorymanagement.demo.entity.Student;
import dodv.dormitorymanagement.demo.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    List<Vehicle> getVehiclesByStudentIs(Student student);
    Long countVehicleByStudent(Student student);

}
