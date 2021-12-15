package dodv.dormitorymanagement.demo.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "electricservice")
@NoArgsConstructor
@AllArgsConstructor
public class RoomElectricityService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "numberelec")
    private int numberElec;
    @Column(name ="price")
    private float price;
    @Column(name ="time")
    private Date time;
    @ManyToOne(optional = false)
    @JoinColumn(name = "roomid")
    private Room room;
    @OneToMany(mappedBy = "roomElectricityService")
    List<Bill> roomElectBillList;
}
