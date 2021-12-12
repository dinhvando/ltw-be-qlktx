package dodv.dormitorymanagement.demo.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="visitor")
@NoArgsConstructor
@AllArgsConstructor
public class Visitor {
    @Id
    @Column(name="visitorIDCard")
    private String visitorId;
    @Column(name="name")
    private String name;
    @OneToMany(mappedBy = "visitor" , cascade = CascadeType.ALL)
    List<Visit> visitList;
    @ManyToMany(mappedBy = "visitors")
    Set<Student> studentList;

    public Visitor(String visitorId, String name) {
        this.visitorId = visitorId;
        this.name = name;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public String getName() {
        return name;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVisitList(List<Visit> visitList) {
        this.visitList = visitList;
    }

    public void setStudentList(Set<Student> studentList) {
        this.studentList = studentList;
    }
}
