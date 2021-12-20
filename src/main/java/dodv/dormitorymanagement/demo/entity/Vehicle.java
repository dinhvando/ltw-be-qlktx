package dodv.dormitorymanagement.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vehicle")
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @Column(name = "licenseplate")
    private String licensePlate;
    @ManyToOne(optional = false)
    @JoinColumn(name = "studentid")
    private Student student;
    @OneToMany(cascade =  CascadeType.ALL, mappedBy = "vehicle")
    List<MonthlyVehicleRegister> monthlyVehicleRegisterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle")
    List<Parking> parkingHistory;
    public Vehicle(String licensePlate, Student student) {
        this.licensePlate = licensePlate;
        this.student = student;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Student getStudent() {
        return student;
    }
}
