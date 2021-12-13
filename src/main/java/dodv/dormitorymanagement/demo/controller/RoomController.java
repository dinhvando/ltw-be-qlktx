package dodv.dormitorymanagement.demo.controller;

import dodv.dormitorymanagement.demo.dto.request.RoomRequestDTO;
import dodv.dormitorymanagement.demo.dto.response.RoomDTO;
import dodv.dormitorymanagement.demo.service.RoomService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room/")
@Transactional
@Log4j2
public class RoomController {
    @Autowired
    RoomService roomService;
    @GetMapping("/all-rooms")
    public List<RoomDTO> getAllRooms(){
        return roomService.getAllRooms();
    }
    @PostMapping("/create-room")
    public void createRoom(@RequestBody RoomRequestDTO roomRequest){
        roomService.createRoom(roomRequest);
    }
}
