package dodv.dormitorymanagement.demo.entity;

import javax.persistence.Column;

public class View {
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "room_price")
    private double roomPrice;

    @Column(name = "type")
    private String type;

    @Column(name = "max_people")
    private int maxPeople;
}
