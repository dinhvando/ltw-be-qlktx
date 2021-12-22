package dodv.dormitorymanagement.demo.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="student")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @Column(name="studentID")
    private String studentID;
    @Column(name="name")
    private String name;
    @Column(name="address")
    private String address;
    @Column(name="dateofbirth")
    private Date dateOfBirth;
    @Column(name="image")
    private String image;
    @ManyToOne
    @JoinColumn(name="classID")
    private Class className;
    @OneToMany(mappedBy = "student" , cascade = CascadeType.ALL)
    List<Visit> visitList;
    @ManyToOne
    @JoinColumn(name="roomID")
    private Room room;
    @ManyToMany(cascade = CascadeType.ALL)
     @JoinTable(
         name = "visit",
         joinColumns ={@JoinColumn(name="studentID")},
         inverseJoinColumns = {@JoinColumn(name="visitorID")}
     )
    Set<Visitor> visitors;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    List<StudentFood> foodServices;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    List<StudentLaundry> laundryServices;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    List<Bill> studentBills;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    Set<Vehicle> vehicles;
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    User user;
    public Student(String studentID, String name, String address, Date dateOfBirth, String image, Class className, Room room) {
        this.studentID = studentID;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.image = image;
        this.className = className;
        this.room = room;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Class getClassName() {
        return className;
    }

    public void setClassName(Class className) {
        this.className = className;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setVisitList(List<Visit> visitList) {
        this.visitList = visitList;
    }

    public void setVisitors(Set<Visitor> visitors) {
        this.visitors = visitors;
    }

    public void setFoodServices(List<StudentFood> foodServices) {
        this.foodServices = foodServices;
    }


    public void setLaundryServices(List<StudentLaundry> laundryServices) {
        this.laundryServices = laundryServices;
    }
}
