package dodv.dormitorymanagement.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "laundryservice")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentLaundryService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "price")
    private float price;
    @Column(name = "time")
    private Date time;
    @ManyToOne(optional = false)
    @JoinColumn(name = "studentID")
    private Student student;
    @OneToOne(mappedBy = "studentLaundryService")
    private Bill bill;
}
