package mk.ukim.finki.wp.lab.service.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.repository.jpa.ChefRepositoryJPA;
import mk.ukim.finki.wp.lab.repository.jpa.DishRepositoryJPA;
import mk.ukim.finki.wp.lab.repository.mock.ChefRepository;
import mk.ukim.finki.wp.lab.repository.mock.DishRepository;
import mk.ukim.finki.wp.lab.service.ChefService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChefServiceImpl implements ChefService {
    private final ChefRepositoryJPA chefRepository;
    private final DishRepositoryJPA dishRepository;

    public ChefServiceImpl(ChefRepositoryJPA chefRepository, DishRepositoryJPA dishRepository) {
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

        if (chefi4.getDishes().contains(tanjir)) {
            System.out.println("DISH ALREADY EXISTS");
        } else {
            chefi4.getDishes().add(tanjir);
        }
        //brato zad nas place le od pree?

        return chefRepository.save(chefi4);
    }

    @Override
    @Transactional
    public void removeDish(Long chefId, String dishId) {
        chefRepository.removeDish(chefId, dishId);
    }
}
