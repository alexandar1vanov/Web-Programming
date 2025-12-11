package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.repository.jpa.ChefRepositoryJPA;
import mk.ukim.finki.wp.lab.repository.jpa.DishRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DataHolder {
    private final DishRepositoryJPA dishRepositoryJPA;
    private final ChefRepositoryJPA chefRepositoryJPA;

    public DataHolder(DishRepositoryJPA dishRepositoryJPA, ChefRepositoryJPA chefRepositoryJPA) {
        this.dishRepositoryJPA = dishRepositoryJPA;
        this.chefRepositoryJPA = chefRepositoryJPA;
    }

    @PostConstruct
    public void init() {
        chefRepositoryJPA.save(new Chef("Sara", "Chipevska", "Sara Chipevska has been mastering traditional Italian cuisine for over 15 years. Known for her handmade pasta and wood-fired pizzas, she brings a taste of Italy to every dish he prepares."));
        chefRepositoryJPA.save(new Chef("Aleksandar", "Ivanov", "Aleksandar Ivanov specializes in sushi and kaiseki cuisine. With a focus on fresh ingredients and delicate presentation, she combines tradition with modern flair in her dishes."));
        chefRepositoryJPA.save(new Chef("Pierre", "Dopout", "Pierre Dupont is a Michelin-starred chef known for his exquisite French pastries and fine dining creations. His attention to detail and elegant plating is unmatched."));
        chefRepositoryJPA.save(new Chef("Sofia", "Hernandez", "Sofia Hernandez brings authentic Mexican flavors to life with her vibrant dishes. Her specialty is traditional mole sauces and street food-inspired tacos."));
//        chefs.addAll(List.of(c, a, b));

        dishRepositoryJPA.save( new Dish("3L", "Pasta", "Italian", 15));
        dishRepositoryJPA.save(new Dish("4L", "Sushi", "Kaiseki", 12));
        dishRepositoryJPA.save(new Dish("5L", "Pastries", "French", 5));
        dishRepositoryJPA.save(new Dish("6L", "Tacos", "Mexican", 30));

//        dishes.addAll(List.of(m, n, p, nj));

    }
}