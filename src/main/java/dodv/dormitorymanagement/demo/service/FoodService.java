package dodv.dormitorymanagement.demo.service;

import dodv.dormitorymanagement.demo.dto.request.FoodEditRequestDTO;
import dodv.dormitorymanagement.demo.dto.request.FoodRequestDTO;
import dodv.dormitorymanagement.demo.dto.response.ClassDTO;
import dodv.dormitorymanagement.demo.dto.response.FoodDTO;
import dodv.dormitorymanagement.demo.entity.Class;
import dodv.dormitorymanagement.demo.entity.Food;
import dodv.dormitorymanagement.demo.repository.FoodRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    @Autowired
    FoodRepository foodRepository;
    public List<FoodDTO> getAllFoodOptions() {
        List<FoodDTO> result = new LinkedList<>();
        List<Food> foodOptions = foodRepository.findAll();
        for (Food x : foodOptions) {
            result.add(FoodDTO.builder().id(x.getId()).foodOption(x.getFoodOption()).price(x.getPrice()).build());
        }
        return result;
    }
    public void createFoodOption(@NotNull FoodRequestDTO foodRequest) {
        Food savedFood = new Food();
        savedFood.setFoodOption(foodRequest.getFoodOption());
        savedFood.setPrice(foodRequest.getPrice());
        foodRepository.save(savedFood);
    }
    public void updateFoodOption(@NotNull FoodEditRequestDTO foodRequest){
        Optional<Food> editedFood = foodRepository.findById(foodRequest.getId());
        if(editedFood.isPresent()){
            Food x = editedFood.get();
            x.setPrice(foodRequest.getPrice());
            foodRepository.save(x);
        }
    }
}
