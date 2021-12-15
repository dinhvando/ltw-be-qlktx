package dodv.dormitorymanagement.demo.dto.request;

import dodv.dormitorymanagement.demo.enumuration.EFoodType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodRequestDTO {
    private EFoodType foodOption;
    private float price;
}
