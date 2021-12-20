package dodv.dormitorymanagement.demo.controller;

import dodv.dormitorymanagement.demo.dto.request.MonthlyParkingRegisterRequestDTO;
import dodv.dormitorymanagement.demo.dto.request.ParkingRequestDTO;
import dodv.dormitorymanagement.demo.dto.request.VehicleRequestDTO;
import dodv.dormitorymanagement.demo.dto.response.VehicleDTO;
import dodv.dormitorymanagement.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle/")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;
    @GetMapping("/get-all-vehicles")
    public List<VehicleDTO> getAllVehicles(){
        return vehicleService.getAllVehicles();
    }
    @GetMapping("/get-vehicles-by-student")
    public List<VehicleDTO> getAllVehiclesByStudents(@RequestParam("studentID") String studentID){
        return vehicleService.getAllVehiclesByStudent(studentID);
    }

    @PostMapping("/create-vehicle")
    public void createVehicle(@RequestBody VehicleRequestDTO inputVehicle){
        vehicleService.createVehicle(inputVehicle);
    }

    @PostMapping("/monthly-register")
    public void monthlyRegister(@RequestBody MonthlyParkingRegisterRequestDTO input){
        vehicleService.monthlyRegister(input);
    }

    @PostMapping("/check-in-out")
    public void checkInAndCheckout(@RequestBody ParkingRequestDTO parkingRequest){
        vehicleService.checkInAndCheckout(parkingRequest);
    }
}
