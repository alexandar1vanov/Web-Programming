package mk.ukim.finki.wp.lab.repository.impl;

import java.util.Optional;
import javax.xml.crypto.Data;
import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.repository.DishRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryDishRepository implements DishRepository {

    @Override
    public List<Dish> findAll() {
        return DataHolder.dishes;
    }

    @Override
    public Dish findByDishId(String dishId) {
        return DataHolder.dishes.stream()
            .filter(d -> d.getDishId().equals(dishId))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Couldn't find Dish with dishId: " + dishId));
    }

    @Override
    public Optional<Dish> findById(Long id) {
        Dish dish = DataHolder.dishes.stream()
            .filter(d -> d.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Couldn't find Dish with id: " + id));
        return Optional.of(dish);
    }

    @Override
    public Dish save(Dish dish) {
        DataHolder.dishes.removeIf(d -> d.getId().equals(dish.getId()));
        DataHolder.dishes.add(dish);
        return dish;
    }

    @Override
    public void deleteById(Long id) {
        DataHolder.dishes.removeIf(d -> d.getId().equals(id));
    }
}
