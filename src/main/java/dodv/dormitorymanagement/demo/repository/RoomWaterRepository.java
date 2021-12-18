package dodv.dormitorymanagement.demo.repository;

import dodv.dormitorymanagement.demo.entity.RoomWater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;

@Repository
public interface RoomWaterRepository extends JpaRepository<RoomWater, Integer> {
    Optional<RoomWater> getDistinctByTimeIs(Date time);
}
