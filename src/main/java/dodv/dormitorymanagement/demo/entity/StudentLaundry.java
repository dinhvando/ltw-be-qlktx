package dodv.dormitorymanagement.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "laundryservice")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentLaundry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "price")
    private float price;
    @Column(name = "time")
    @Temporal(TemporalType.DATE)
    private Date time;
    @ManyToOne(optional = false)
    @JoinColumn(name = "studentID")
    private Student student;
    @OneToOne(mappedBy = "studentLaundry")
    private Bill bill;
}
