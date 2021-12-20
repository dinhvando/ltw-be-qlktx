package dodv.dormitorymanagement.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "view_student_bill_detail")
public class ViewStudentBillDetail {

    @Id
    @Column(name = "studentid", insertable = false, updatable = false)
    private String studentId;

    @Column(name = "studentname", insertable = false, updatable = false)
    private String studentName;

    @Column(name = "roomname", insertable = false, updatable = false)
    private String roomName;

    @Column(name = "priceroom", insertable = false, updatable = false)
    private Float priceRoom;

    @Column(name = "pricefood", insertable = false, updatable = false)
    private Float priceFood;

    @Column(name = "pricelaundry", insertable = false, updatable = false)
    private Float priceLaundry;

    @Column(name = "pricewater", insertable = false, updatable = false)
    private Float priceWater;

    @Column(name = "priceelec", insertable = false, updatable = false)
    private Float priceElec;

    @Column(name = "total", insertable = false, updatable = false)
    private Float total;

    @Temporal(TemporalType.DATE)
    @Column(name = "time", insertable = false, updatable = false)
    private Date time;
}
