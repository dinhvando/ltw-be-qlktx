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
public class RoomElectricityRequestDTO {
    private int roomID;
    private int numberElect;
    private float price;
    private Date time;
}
