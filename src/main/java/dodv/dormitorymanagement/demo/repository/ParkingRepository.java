package dodv.dormitorymanagement.demo.repository;

import dodv.dormitorymanagement.demo.entity.Parking;
import dodv.dormitorymanagement.demo.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ParkingRepository extends JpaRepository<Parking, Integer> {
    @Query(value = "Select count(p.checkIn)  from parking p where cast(p.checkIn as DATE) = curdate() and p.licensePlate = ?1", nativeQuery  = true)
    Long theNumberOfTimesCheckIn(String licensePlate);
    Optional<Parking> findFirstByVehicleOrderByIdDesc(Vehicle vehicle);
}
