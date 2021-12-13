package dodv.dormitorymanagement.demo.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomRequestDTO {
    private String name;
    private double price;
    private String roomType;
    private int maxPeople;
}
