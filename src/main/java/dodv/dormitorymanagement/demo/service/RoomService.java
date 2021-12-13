package dodv.dormitorymanagement.demo.service;


import dodv.dormitorymanagement.demo.dto.request.RoomRequestDTO;
import dodv.dormitorymanagement.demo.dto.response.RoomDTO;
import dodv.dormitorymanagement.demo.entity.Room;
import dodv.dormitorymanagement.demo.repository.RoomRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;

    public List<RoomDTO> getAllRooms() {
        List<RoomDTO> result = new LinkedList<>();
        List<Room> roomList = roomRepository.findAll();
        for (Room x : roomList) {
            result.add(
                    RoomDTO.builder().id(x.getId())
                            .name(x.getName())
                            .price(x.getPriceRoom())
                            .roomType(x.getType())
                            .maxPeople(x.getMaxPeople())
                            .build()
            );

        }
        return result;
    }

    public void createRoom(@NotNull RoomRequestDTO requestDTO) {
        roomRepository.save(new Room(requestDTO.getName(),requestDTO.getPrice(),requestDTO.getRoomType(),
                requestDTO.getMaxPeople()));
    }
}
