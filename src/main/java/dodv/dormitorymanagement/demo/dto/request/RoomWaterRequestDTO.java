package dodv.dormitorymanagement.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomWaterRequestDTO {
    private int roomID;
    private int numberWater;
    private float price;
    private Date time;
}
