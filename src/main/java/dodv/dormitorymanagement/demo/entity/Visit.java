package dodv.dormitorymanagement.demo.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="visit")
public class Visit {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="time")
    private Date time;
    @ManyToOne
    @JoinColumn(name="studentID")
    private Student student;
    @ManyToOne
    @JoinColumn(name="visitorID")
    private Visitor visitor;
    public Visit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public Student getStudent() {
        return student;
    }

    public Visitor getVisitor() {
        return visitor;
    }
}
