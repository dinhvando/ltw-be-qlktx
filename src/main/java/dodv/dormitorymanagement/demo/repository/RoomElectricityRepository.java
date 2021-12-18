package dodv.dormitorymanagement.demo.repository;

import dodv.dormitorymanagement.demo.entity.Room;
import dodv.dormitorymanagement.demo.entity.RoomElectricity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;

@Repository
public interface RoomElectricityRepository extends JpaRepository<RoomElectricity, Integer> {
    Optional<RoomElectricity> getDistinctByTimeIs(Date time);
}
