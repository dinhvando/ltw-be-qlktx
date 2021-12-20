package dodv.dormitorymanagement.demo.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleDTO {
    private String studentID;
    private String name;
    private String licensePlate;
}
