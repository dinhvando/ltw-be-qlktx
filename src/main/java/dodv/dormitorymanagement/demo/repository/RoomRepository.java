package dodv.dormitorymanagement.demo.repository;

import dodv.dormitorymanagement.demo.dto.response.RoomBillDetailDTO;
import dodv.dormitorymanagement.demo.dto.response.Test;
import dodv.dormitorymanagement.demo.entity.Room;
import dodv.dormitorymanagement.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query(value = "Select m.students from Room m where m.id = ?1")
    List<Student> getAllStudents(Integer id);
    @Query(value = "select new dodv.dormitorymanagement.demo.dto.response.RoomBillDetailDTO" +
            "(r.id, r.name, cast (r.priceRoom as double),  cast (re.numberElec*re.price as double), cast (rw.numberWater*rw.price as double), " +
            "rw.time) " +
            "From Room r,  RoomElectricity  re,RoomWater rw " +
            "            where r =  ?1 " +
            "            and r = re.room and r = rw.room and re.time = rw.time")
    List<RoomBillDetailDTO> getAllBillsByRoom(Room room);
}
