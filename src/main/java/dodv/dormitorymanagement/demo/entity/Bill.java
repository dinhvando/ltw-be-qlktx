package dodv.dormitorymanagement.demo.entity;

import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name ="bill")
@Setter
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name ="time")
    private Date time;
    @ManyToOne(optional = false)
    @JoinColumn(name = "studentID")
    private Student student;
    @ManyToOne(optional = false)
    @JoinColumn(name = "roomID")
    private Room room;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "foodsvid", referencedColumnName = "id")
    private StudentFood studentFood;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "laundrysvid", referencedColumnName = "id")
    private StudentLaundry studentLaundry;
    @ManyToOne
    @JoinColumn(name = "watersvid")
    private RoomWater roomWater;
    @ManyToOne
    @JoinColumn(name = "elecsvid")
    private RoomElectricity roomElectricity;

}
