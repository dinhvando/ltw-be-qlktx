package dodv.dormitorymanagement.demo.controller;

import dodv.dormitorymanagement.demo.dto.request.FoodEditRequestDTO;
import dodv.dormitorymanagement.demo.dto.request.FoodRequestDTO;
import dodv.dormitorymanagement.demo.dto.response.FoodDTO;
import dodv.dormitorymanagement.demo.service.FoodService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food/")
public class FoodController {
    @Autowired
    FoodService foodService;
    @GetMapping("/get-all-food-options")
    public List<FoodDTO> getAllFoodOptions(){
        return foodService.getAllFoodOptions();
    }
    @PostMapping("/create-food-option")
    public void createFoodOption(@RequestBody FoodRequestDTO foodRequest ){
        foodService.createFoodOption(foodRequest);
    }
    @PostMapping("/update-food-option")
    public void updateFoodOption(@RequestBody FoodEditRequestDTO editFood){
        foodService.updateFoodOption(editFood);
    }
}
