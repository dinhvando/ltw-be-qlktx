package dodv.dormitorymanagement.demo.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisitorRequestDTO {
    private String visitorIdCard;
    private String name;
}
