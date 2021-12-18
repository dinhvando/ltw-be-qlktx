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
public class BillRequestDTO {
    private String studentID;
    private int roomID;
    private int foodSvId;
    private int laundrySvId;
    private int waterSvId;
    private int electSvId;
    private Date time;
}
