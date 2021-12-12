package dodv.dormitorymanagement.demo.dto.response;

import lombok.*;

import java.sql.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
    private String studentID;
    private String name;
    private String address;
    private Date dateOfBirth;
    private String image;
    private ClassDTO studentClass;
}
