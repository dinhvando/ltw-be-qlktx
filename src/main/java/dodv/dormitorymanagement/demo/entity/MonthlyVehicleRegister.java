package dodv.dormitorymanagement.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "monthlyvehicleregister")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyVehicleRegister  {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name ="time")
    @Temporal(TemporalType.DATE)
    private Date time;
    @ManyToOne(optional = false)
    @JoinColumn(name = "licenseplate")
    private Vehicle vehicle;

}
