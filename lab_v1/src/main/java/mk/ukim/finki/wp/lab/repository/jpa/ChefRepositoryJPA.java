package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChefRepositoryJPA extends JpaRepository<Chef,Long> {
    List<Chef> findAll();

    Optional<Chef> findById(Long id);

    Chef save(Chef chef);

    @Modifying
    @Query(value = "update Dish d set d.chef=null where d.chef.id = :chefId and d.dishId = :dishId")
    void removeDish(Long chefId,String dishId);
}
