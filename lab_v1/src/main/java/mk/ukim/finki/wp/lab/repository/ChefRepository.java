package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Chef;

import java.util.List;
import java.util.Optional;
import java.util.SimpleTimeZone;

public interface ChefRepository {
    List<Chef> findAll();
    Optional<Chef> findById(Long id);
    Chef save(Chef chef);
    void removeDish(Long chefId, String dishId);
}
