package dodv.dormitorymanagement.demo.auth;

import dodv.dormitorymanagement.demo.dto.request.RegisterRequestDTO;
import dodv.dormitorymanagement.demo.entity.Student;
import dodv.dormitorymanagement.demo.entity.User;
import dodv.dormitorymanagement.demo.repository.StudentRepository;
import dodv.dormitorymanagement.demo.repository.UserRepository;
import dodv.dormitorymanagement.demo.security.PasswordConfig;
import org.checkerframework.checker.units.qual.A;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ApplicationUserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new ApplicationUser(user);
    }
    public void register(@NotNull RegisterRequestDTO registerRequestDTO){
        Student student = studentRepository.getById(registerRequestDTO.getStudentID());
        if(student == null){
            throw new ResponseStatusException( HttpStatus.EXPECTATION_FAILED, "Student with studentID: " + student.getStudentID() + " is not existed");
        }else{
            if(userRepository.findByStudent(student) != null){
                throw new ResponseStatusException( HttpStatus.EXPECTATION_FAILED, "Student with studentID: " + student.getStudentID() + " is already registered");
            }else{
                PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String encodedPassword = passwordEncoder.encode(registerRequestDTO.getPassword());
                User u = new User();
                u.setUsername(registerRequestDTO.getUsername());
                u.setPassword(encodedPassword);
                u.setStudent(student);
                u.setRole("ROLE_STUDENT");
                userRepository.save(u);
            }
        }


    }

}
