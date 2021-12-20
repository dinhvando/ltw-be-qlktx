package dodv.dormitorymanagement.demo.dto.response;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomBillDetailDTO {
    private int roomID;
    private String roomName;
    private double priceRoom;
    private double priceElectricity;
    private double priceWater;
    private Date time;
}
