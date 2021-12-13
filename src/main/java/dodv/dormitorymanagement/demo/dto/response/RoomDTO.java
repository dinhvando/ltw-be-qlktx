package dodv.dormitorymanagement.demo.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomDTO {
    private int id;
    private String name;
    private double price;
    private String roomType;
    private int maxPeople;
}
