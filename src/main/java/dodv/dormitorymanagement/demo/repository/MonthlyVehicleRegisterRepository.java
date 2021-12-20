package dodv.dormitorymanagement.demo.repository;

import dodv.dormitorymanagement.demo.entity.MonthlyVehicleRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MonthlyVehicleRegisterRepository extends JpaRepository<MonthlyVehicleRegister, Integer> {
    @Query(value = "Select count(m.licenseplate) \n" +
            "from monthlyvehicleregister m\n" +
            "where MONTH(curdate()) = MONTH(m.time ) AND \n" +
            "YEAR (curdate()) = YEAR (m.time) AND \n" +
            "m.licenseplate = ?1", nativeQuery = true)
    Long isRegistedByMonth(String licensePlate);
}
