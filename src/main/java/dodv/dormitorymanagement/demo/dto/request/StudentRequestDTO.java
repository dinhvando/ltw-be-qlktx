package dodv.dormitorymanagement.demo.dto.request;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequestDTO {
    private String studentID;
    private String name;
    private Date dateOfBirth;
    private String address;
    private String image;
    private int roomID;
    private int classID;
}
