package dodv.dormitorymanagement.demo.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleRequestDTO {
    private String licensePlate;
    private String studentID;
}
