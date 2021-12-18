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
public class LaundryServiceRequestDTO {
    private String studentID;
    private Date time;
    private float price;
}
