package dodv.dormitorymanagement.demo.service;


import dodv.dormitorymanagement.demo.dto.request.RoomElectricityRequestDTO;
import dodv.dormitorymanagement.demo.dto.request.RoomRequestDTO;
import dodv.dormitorymanagement.demo.dto.request.RoomWaterRequestDTO;
import dodv.dormitorymanagement.demo.dto.response.RoomBillDetailDTO;
import dodv.dormitorymanagement.demo.dto.response.RoomDTO;
import dodv.dormitorymanagement.demo.entity.*;
import dodv.dormitorymanagement.demo.repository.BillRepository;
import dodv.dormitorymanagement.demo.repository.RoomElectricityRepository;
import dodv.dormitorymanagement.demo.repository.RoomRepository;
import dodv.dormitorymanagement.demo.repository.RoomWaterRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    RoomElectricityRepository roomElectricityRepository;
    @Autowired
    RoomWaterRepository roomWaterRepository;
    @Autowired
    BillRepository billRepository;


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
        roomRepository.save(new Room(requestDTO.getName(), requestDTO.getPrice(), requestDTO.getRoomType(),
                requestDTO.getMaxPeople()));
    }

    @Transactional
    public void insertElectricityService(@NotNull RoomElectricityRequestDTO inputRoomElectricity) {
        RoomElectricity insertedRoomElectricity = new RoomElectricity();
        Optional<RoomElectricity> res = roomElectricityRepository.getDistinctByTimeIs(inputRoomElectricity.getTime());
        if (res.isPresent()) {
            // sua
            RoomElectricity x = res.get();
            x.setNumberElec(inputRoomElectricity.getNumberElect());
            x.setPrice((inputRoomElectricity.getPrice()));
            roomElectricityRepository.save(x);
            List<Student> allStudentsByRoom = roomRepository.getAllStudents(inputRoomElectricity.getRoomID());
            updateElectBillFollowingStudent(allStudentsByRoom, inputRoomElectricity.getTime(),x);
        } else {
            // them
            Room foundRoom = roomRepository.findById(inputRoomElectricity.getRoomID()).get();
            insertedRoomElectricity.setRoom(foundRoom);
            insertedRoomElectricity.setNumberElec(inputRoomElectricity.getNumberElect());
            insertedRoomElectricity.setPrice((inputRoomElectricity.getPrice()));
            insertedRoomElectricity.setTime(inputRoomElectricity.getTime());
            roomElectricityRepository.save(insertedRoomElectricity);
            List<Student> allStudentsByRoom = roomRepository.getAllStudents(inputRoomElectricity.getRoomID());
            updateElectBillFollowingStudent(allStudentsByRoom, inputRoomElectricity.getTime(),insertedRoomElectricity);
        }




    }
    @Transactional
    public void insertWaterService(@NotNull RoomWaterRequestDTO inputRoomWater){
        RoomWater insertedRoomWater = new RoomWater();
        Optional<RoomWater> res = roomWaterRepository.getDistinctByTimeIs(inputRoomWater.getTime());
        if (res.isPresent()) {
            // sua
            RoomWater x = res.get();
            x.setNumberWater(inputRoomWater.getNumberWater());
            x.setPrice((inputRoomWater.getPrice()));
            roomWaterRepository.save(x);
            List<Student> allStudentsByRoom = roomRepository.getAllStudents(inputRoomWater.getRoomID());
            updateWaterBillFollowingStudent(allStudentsByRoom, inputRoomWater.getTime(),x);
        } else {
            // them
            Room foundRoom = roomRepository.findById(inputRoomWater.getRoomID()).get();
            insertedRoomWater.setRoom(foundRoom);
            insertedRoomWater.setNumberWater(inputRoomWater.getNumberWater());
            insertedRoomWater.setPrice((inputRoomWater.getPrice()));
            insertedRoomWater.setTime(inputRoomWater.getTime());
            roomWaterRepository.save(insertedRoomWater);
            List<Student> allStudentsByRoom = roomRepository.getAllStudents(inputRoomWater.getRoomID());
            updateWaterBillFollowingStudent(allStudentsByRoom, inputRoomWater.getTime(),insertedRoomWater);
        }
    }
    // get bills by room
    public List<RoomBillDetailDTO> getBillsByRoom(Integer roomID){
        Room room = roomRepository.getById(roomID);
        return roomRepository.getAllBillsByRoom(room);
    }
    private void updateElectBillFollowingStudent(@NotNull List<Student> students, Date time, RoomElectricity roomElectricity) {
        for (Student student : students) {
            List<Bill> billsBelongToStudent = billRepository.getAllBillsByStudentAndTime(student, time);
            if (billsBelongToStudent.size() > 0) {
                // student da ton tai trong bill
                Bill billStudent = billsBelongToStudent.get(0);
                billStudent.setRoomElectricity(roomElectricity);
                billStudent.setTime(time);
                billRepository.saveAll(billsBelongToStudent);
            } else {
                // chua ton tai
                Bill addedBill = new Bill();
                addedBill.setStudent(student);
                addedBill.setRoomElectricity(roomElectricity);
                addedBill.setRoom(roomElectricity.getRoom());
                addedBill.setTime(time);
                billRepository.save(addedBill);
            }

        }
    }
    private void updateWaterBillFollowingStudent(@NotNull List<Student> students, Date time, RoomWater roomWater){
        for (Student student : students) {
            List<Bill> billsBelongToStudent = billRepository.getAllBillsByStudentAndTime(student, time);
            if (billsBelongToStudent.size() > 0) {
                // student da ton tai trong bill
                Bill billStudent = billsBelongToStudent.get(0);
                billStudent.setRoomWater(roomWater);
                billStudent.setTime(time);
                billRepository.saveAll(billsBelongToStudent);
            } else {
                // chua ton tai
                Bill addedBill = new Bill();
                addedBill.setStudent(student);
                addedBill.setRoomWater(roomWater);
                addedBill.setRoom(roomWater.getRoom());
                addedBill.setTime(time);
                billRepository.save(addedBill);
            }

        }
    }
}
