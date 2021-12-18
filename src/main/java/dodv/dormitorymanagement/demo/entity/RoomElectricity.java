package dodv.dormitorymanagement.demo.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "electricservice")
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class RoomElectricity {
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
    @OneToMany(mappedBy = "roomElectricity")
    List<Bill> roomElectBillList;

    public int getId() {
        return id;
    }

    public int getNumberElec() {
        return numberElec;
    }

    public float getPrice() {
        return price;
    }

    public Date getTime() {
        return time;
    }

    public Room getRoom() {
        return room;
    }
}
