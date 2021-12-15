package dodv.dormitorymanagement.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "foodservice")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentFoodService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "totalday")
    private int totalDay;
    @Column(name = "time")
    private Date time;
    @ManyToOne(optional = false)
    @JoinColumn(name = "foodID")
    private Food food;
    @ManyToOne(optional = false)
    @JoinColumn(name = "studentID")
    private Student student;
    @OneToOne(mappedBy = "studentFoodService")
    private Bill bill;
}
