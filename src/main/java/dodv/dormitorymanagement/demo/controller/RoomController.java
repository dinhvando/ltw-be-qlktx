package dodv.dormitorymanagement.demo.controller;

import dodv.dormitorymanagement.demo.dto.request.EditRoomRequestDTO;
import dodv.dormitorymanagement.demo.dto.request.RoomElectricityRequestDTO;
import dodv.dormitorymanagement.demo.dto.request.RoomRequestDTO;
import dodv.dormitorymanagement.demo.dto.request.RoomWaterRequestDTO;
import dodv.dormitorymanagement.demo.dto.response.RoomBillDetailDTO;
import dodv.dormitorymanagement.demo.dto.response.RoomDTO;
import dodv.dormitorymanagement.demo.entity.Room;
import dodv.dormitorymanagement.demo.service.RoomService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room/")
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

    @PostMapping("/update-room")
    public void updateRoom(@RequestBody EditRoomRequestDTO editRoom){
        roomService.updateRoom(editRoom);
    }

    @PostMapping("/insert-electricity-service")
    public void insertElectricityService(@RequestBody  RoomElectricityRequestDTO inputRoomElectricity){
        roomService.insertElectricityService(inputRoomElectricity);
    }

    @PostMapping("/insert-water-service")
    public void insertWaterService(@RequestBody RoomWaterRequestDTO inputRoomWater){
        roomService.insertWaterService(inputRoomWater);
    }

    @GetMapping("/get-bills-by-room/{roomID}")
    public List<RoomBillDetailDTO> getBillsByRoom(@PathVariable Integer roomID){
        return roomService.getBillsByRoom(roomID);
    }

    @GetMapping("/get-active-room")
    public List<RoomDTO> getActiveRooms(){
        return roomService.getActiveRooms();
    }
}
