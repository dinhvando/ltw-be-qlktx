package dodv.dormitorymanagement.demo.entity;

import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "waterservice")
@Setter
public class RoomWaterService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "numberwater")
    private int numberWater;
    @Column(name ="price")
    private float price;
    @Column(name ="time")
    private Date time;
    @ManyToOne(optional = false)
    @JoinColumn(name = "roomid")
    private Room room;
    @OneToMany(mappedBy = "roomWaterService")
    List<Bill> roomWaterBillList;
}
