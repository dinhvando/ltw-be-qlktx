package dodv.dormitorymanagement.demo.repository;

import dodv.dormitorymanagement.demo.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
//    @Query(value = "select room2.id,room2.name,room2.priceRoom,room2.type,room2.maxPeople from" +
//            " select m from room m left join" +
//            "select student.roomID, count(roomID) as people  from student " +
//            "group by roomID as room1" +
//            "on room.id = room1.roomID as room2" +
//            "where room2.maxPeople > room2.people  or room2.people  is null")
//    Collection<Room> getUnFullRoom();

}
