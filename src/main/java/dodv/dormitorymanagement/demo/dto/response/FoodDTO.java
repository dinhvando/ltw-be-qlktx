package dodv.dormitorymanagement.demo.dto.response;

import dodv.dormitorymanagement.demo.enumuration.EFoodType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodDTO {
    private int id;
    private EFoodType foodOption;
    private float price;
}
