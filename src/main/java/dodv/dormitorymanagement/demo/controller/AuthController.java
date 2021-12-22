package dodv.dormitorymanagement.demo.controller;

import dodv.dormitorymanagement.demo.auth.ApplicationUser;
import dodv.dormitorymanagement.demo.auth.ApplicationUserService;
import dodv.dormitorymanagement.demo.dto.request.LoginRequestDTO;
import dodv.dormitorymanagement.demo.dto.request.RegisterRequestDTO;
import dodv.dormitorymanagement.demo.dto.response.JWTResponseDTO;
import dodv.dormitorymanagement.demo.security.jwt.JwtConfig;
import dodv.dormitorymanagement.demo.security.jwt.UsernameAndPasswordRequest;
import io.jsonwebtoken.Jwts;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.time.LocalDate;
import java.util.Date;

@RestController

public class AuthController {
    @Autowired
    private JwtConfig jwtConfig;
    @Autowired
    private  SecretKey secretKey;
    @Autowired
    ApplicationUserService applicationUserService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO input){
      UserDetails user = applicationUserService.loadUserByUsername(input.getUsername());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
      if(user == null || !passwordEncoder.matches(input.getPassword(), user.getPassword())){
          return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Your username/password is not correct");
      }
        String token = Jwts.builder()
                .setSubject(user.getUsername())
                .claim("authorities", user.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(jwtConfig.getTokenExpirationAfterDays())))
                .signWith(secretKey)
                .compact();
      return ResponseEntity.status(HttpStatus.OK).body(JWTResponseDTO.builder().token(token).build());
    }
    @PostMapping("/register")
    public void register(@RequestBody RegisterRequestDTO input){
        applicationUserService.register(input);
    }


}
