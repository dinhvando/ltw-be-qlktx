package dodv.dormitorymanagement.demo.service;

import dodv.dormitorymanagement.demo.dto.request.MonthlyParkingRegisterRequestDTO;
import dodv.dormitorymanagement.demo.dto.request.ParkingRequestDTO;
import dodv.dormitorymanagement.demo.dto.request.VehicleRequestDTO;
import dodv.dormitorymanagement.demo.dto.response.VehicleDTO;
import dodv.dormitorymanagement.demo.entity.*;
import dodv.dormitorymanagement.demo.repository.MonthlyVehicleRegisterRepository;
import dodv.dormitorymanagement.demo.repository.ParkingRepository;
import dodv.dormitorymanagement.demo.repository.StudentRepository;
import dodv.dormitorymanagement.demo.repository.VehicleRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    MonthlyVehicleRegisterRepository monthlyVehicleRegisterRepository;
    @Autowired
    ParkingRepository parkingRepository;

    public List<VehicleDTO> getAllVehicles() {
        List<VehicleDTO> result = new LinkedList<>();
        List<Vehicle> vehicles = vehicleRepository.findAll();
        for (Vehicle x : vehicles) {
            result.add(VehicleDTO.builder().studentID(x.getStudent().getStudentID()).name(x.getStudent().getName()).licensePlate(x.getLicensePlate()).build());
        }
        return result;
    }

    public List<VehicleDTO> getAllVehiclesByStudent(String studentID) {
        List<VehicleDTO> result = new LinkedList<>();
        Student student = studentRepository.findById(studentID).get();
        List<Vehicle> vehicles = vehicleRepository.getVehiclesByStudentIs(student);
        for (Vehicle x : vehicles) {
            result.add(VehicleDTO.builder().studentID(x.getStudent().getStudentID()).name(x.getStudent().getName()).licensePlate(x.getLicensePlate()).build());
        }
        return result;
    }

    public void createVehicle(@NotNull VehicleRequestDTO inputVehicle) {

        Student student = studentRepository.findById(inputVehicle.getStudentID()).get();
        Long totalVehicles = vehicleRepository.countVehicleByStudent(student);
        if (totalVehicles < 2) {
            vehicleRepository.save(new Vehicle(inputVehicle.getLicensePlate(), student));
        } else {
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "You can't register vehicle more :("
            );
        }
    }


    public void monthlyRegister(@NotNull MonthlyParkingRegisterRequestDTO inputRegister) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(inputRegister.getLicensePlate());
        if(vehicle.isPresent()){
            MonthlyVehicleRegister x = new MonthlyVehicleRegister();
            x.setVehicle(vehicle.get());
            x.setTime(inputRegister.getTime());
            monthlyVehicleRegisterRepository.save(x);
        }else{
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Can't not find your vehicle in DB"
            );
        }

    }

    public void checkInAndCheckout(@NotNull  ParkingRequestDTO parkingRequest) {
        try {
            Optional<Vehicle> vehicle = vehicleRepository.findById(parkingRequest.getLicensePlate());
            if(vehicle.isPresent()){
                Optional<Parking> lastRecord = parkingRepository.findFirstByVehicleOrderByIdDesc(vehicle.get());
                if (lastRecord.isPresent()) {
                    // da tung gui
                    Parking lastRecordOfVehicle = lastRecord.get();
                    if (lastRecordOfVehicle.getCheckOut() == null) {
                        // checkout
                        lastRecordOfVehicle.setCheckOut(new Date());
                        parkingRepository.save(lastRecordOfVehicle);
                    } else {
                        // checkin
                        Parking p = new Parking();
                        p.setVehicle(vehicle.get());
                        p.setCheckIn(new Date());
                        p.setIsFree(checkIsFree(parkingRequest.getLicensePlate()) ? 0 : 1);
                        parkingRepository.save(p);
                    }
                } else {

                    Parking p = new Parking();
                    p.setVehicle(vehicle.get());
                    p.setCheckIn(new Date());
                    p.setIsFree(checkIsFree(parkingRequest.getLicensePlate()) ? 0 : 1);
                    parkingRepository.save(p);
                }
            }else{
                throw new ResponseStatusException(
                        HttpStatus.EXPECTATION_FAILED, "Can't not find your vehicle in DB"
                );
            }


        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Something Wrong"
            );
        }
    }

    private Boolean checkIsFree(String licensePlate) {
        System.out.println(parkingRepository.theNumberOfTimesCheckIn(licensePlate));
        System.out.println(monthlyVehicleRegisterRepository.isRegistedByMonth(licensePlate));
        return parkingRepository.theNumberOfTimesCheckIn(licensePlate) < 2 && monthlyVehicleRegisterRepository.isRegistedByMonth(licensePlate) == 1;
    }
}
