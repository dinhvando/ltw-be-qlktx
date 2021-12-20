package dodv.dormitorymanagement.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "parking")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Parking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "isfree", columnDefinition = "INT default 0")
    private int isFree;
    @Column(name = "checkin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkIn;
    @Column(name ="checkout")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOut;
    @ManyToOne
    @JoinColumn(name = "licenseplate")
    private Vehicle vehicle;
}
