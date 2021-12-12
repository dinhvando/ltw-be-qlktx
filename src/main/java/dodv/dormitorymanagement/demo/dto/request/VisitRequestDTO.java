package dodv.dormitorymanagement.demo.dto.request;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisitRequestDTO {
    private String studentID;
    private String visitorID;
    private Date time;
}
