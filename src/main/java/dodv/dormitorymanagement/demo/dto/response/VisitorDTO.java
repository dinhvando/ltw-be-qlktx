package dodv.dormitorymanagement.demo.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisitorDTO {
    private String visitorIdCard;
    private String name;
}
