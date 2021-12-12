package dodv.dormitorymanagement.demo.dto.response;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisitDTO {
    private int id;
    private String studentName;
    private String visitorName;
    private Date time;
}
