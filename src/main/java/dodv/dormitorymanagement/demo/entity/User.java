package dodv.dormitorymanagement.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "user")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="id")
    private long id;
    @Column(name ="username", unique = true)
    private String username;
    @Column(name = "encryptedPassword")
    private String password;
    @Column(name ="role")
    private String role;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentID", referencedColumnName = "studentID")
    private Student student;



}
