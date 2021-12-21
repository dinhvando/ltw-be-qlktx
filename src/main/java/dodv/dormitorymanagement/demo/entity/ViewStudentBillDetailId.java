package dodv.dormitorymanagement.demo.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class ViewStudentBillDetailId implements Serializable {
    private String studentId;
    private Date time;
}
