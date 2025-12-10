package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "dish_id")
    String dishId;

    @Column(name = "name")
    String name;

    @Column(name = "cuisine")
    String cuisine;

    @Column(name = "preparation_time")
    int preparationTime;

    @ManyToOne
    @JoinColumn(name = "chef_id")
    Chef chef;

    public Dish(String dishId, String name, String cuisine, int preparationTime) {
        this.dishId = dishId;
        this.name = name;
        this.cuisine = cuisine;
        this.preparationTime = preparationTime;
    }

    public Dish(Long id, String dishId, String name, String cuisine, int preparationTime) {
        this.id=id;
        this.dishId=dishId;
        this.name=name;
        this.cuisine=cuisine;
        this.preparationTime=preparationTime;
    }
}
