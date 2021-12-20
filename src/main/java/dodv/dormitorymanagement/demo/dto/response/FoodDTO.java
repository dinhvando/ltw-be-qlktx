package dodv.dormitorymanagement.demo.dto.response;

import dodv.dormitorymanagement.demo.enumuration.EFoodType;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodDTO {
    private int id;
    @Enumerated(EnumType.STRING)
    private EFoodType foodOption;
    private float price;
}
