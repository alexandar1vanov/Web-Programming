package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.repository.ChefRepository;
import mk.ukim.finki.wp.lab.repository.DishRepository;
import mk.ukim.finki.wp.lab.service.ChefService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChefServiceImpl implements ChefService {
    private final ChefRepository chefRepository;
    private final DishRepository dishRepository;

    public ChefServiceImpl(ChefRepository chefRepository, DishRepository dishRepository) {
        this.chefRepository = chefRepository;
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Chef> listChefs() {
        return chefRepository.findAll();
    }

    @Override
    public Chef findById(Long id) {
        return chefRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Couldn't find Chef with id: " + id));
    }

    @Override
    public Chef addDishToChef(Long chefId, String dishId) {
        Chef chefi4 = findById(chefId);
        Dish tanjir = dishRepository.findByDishId(dishId);

        if (chefi4.getDishes().stream().anyMatch(dish -> dish.getDishId().equals(dishId))) {
            System.out.println("DISH ALREADY EXISTS");
        } else {
            chefi4.getDishes().add(tanjir);
        }
        //brato zad nas place le od pree?

        return chefRepository.save(chefi4);
    }

    @Override
    public void removeDish(Long chefId, String dishId) {
        chefRepository.removeDish(chefId,dishId);
    }


}
