package dodv.dormitorymanagement.demo.entity;

import dodv.dormitorymanagement.demo.enumuration.EFoodType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "food")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name ="foodoption")
    private EFoodType foodOption;
    @Column(name = "price")
    private float price;
}
