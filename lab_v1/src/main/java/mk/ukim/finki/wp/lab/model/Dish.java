package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dish {
    private Long id;
    String dishId;
    String name;
    String cuisine;
    int preparationTime;

    public Dish(String dishId, String name, String cuisine, int preparationTime) {
        this.id = (long) (Math.random() * 1000);
        this.dishId = dishId;
        this.name = name;
        this.cuisine = cuisine;
        this.preparationTime = preparationTime;
    }
}
