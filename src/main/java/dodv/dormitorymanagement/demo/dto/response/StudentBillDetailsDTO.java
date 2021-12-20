package dodv.dormitorymanagement.demo.dto.response;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentBillDetailsDTO {
    private String studentID;
    private String studentName;
    private String roomName;
    private double roomPrice;
    private double priceFood;
    private double priceLaundry;
    private double priceWater;
    private double priceElect;
    private Date time;
    public double getTotal(){
        return roomPrice + priceFood + priceLaundry + priceElect;
    }
}
