package dodv.dormitorymanagement.demo.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsernameAndPasswordRequest implements Serializable {
    private String username;
    private String password;
}
