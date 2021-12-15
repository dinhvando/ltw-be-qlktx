package dodv.dormitorymanagement.demo.dto.response;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    private int id;
    private String name;
    private double priceRoom;
    private String type;
    private Integer maxPeople;
}
