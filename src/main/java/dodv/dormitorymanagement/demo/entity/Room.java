package dodv.dormitorymanagement.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name ="name")
    private String name;
    @Column(name = "priceroom")
    private double priceRoom;
    @Column(name ="type")
    private String type;
    @Column(name = "maxpeople")
    private Integer maxPeople;
    @OneToMany(mappedBy = "room" , cascade = CascadeType.ALL)
    List<Student> students;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    List<RoomElectricity> roomElectricityList;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    List<RoomWater> roomWaterList;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    List<Bill> roomBills;
    public Room() {
    }

    public Room(String name, double priceRoom, String type, Integer maxPeople) {
        this.name = name;
        this.priceRoom = priceRoom;
        this.type = type;
        this.maxPeople = maxPeople;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceRoom() {
        return priceRoom;
    }

    public void setPriceRoom(double priceRoom) {
        this.priceRoom = priceRoom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
