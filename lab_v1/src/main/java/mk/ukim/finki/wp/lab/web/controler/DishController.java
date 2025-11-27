package mk.ukim.finki.wp.lab.web.controler;

import jakarta.servlet.http.HttpSession;
import java.util.List;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.service.ChefService;
import mk.ukim.finki.wp.lab.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dishes")
public class DishController {

    private final DishService dishService;
    private final ChefService chefService;

    public DishController(DishService dishService, ChefService chefService) {
        this.dishService = dishService;
        this.chefService = chefService;
    }

    @GetMapping
    public String getDishesPage(@RequestParam(required = false) String error, Model model, HttpSession session) {
        if (error != null) {
            model.addAttribute("error", error);
        }

        Object chefIdObj=(session.getAttribute("chefId"));
        Long chefId = (Long) chefIdObj;
        Chef chef = this.chefService.findById(chefId);
        List<Dish> dishes = dishService.listDishes();
        model.addAttribute("dishes", dishes);
        model.addAttribute("chef", chef);

        return "listDishes";
    }

    @GetMapping("/dish-form/{id}")
    public String getEditDishForm(@PathVariable Long id, Model model) {

        Dish dish = this.dishService.findById(id);
        model.addAttribute("dish", dish);

        return "dish-form";
    }

    @GetMapping("/dish-form")
    public String getAddDishPage(Model model){
        return "dish-form";
    }


    @PostMapping("/add")
    public String saveDish(@RequestParam String dishId,
                           @RequestParam String name,
                           @RequestParam String cuisine,
                           @RequestParam int preparationTime) {
        this.dishService.create(dishId, name, cuisine, preparationTime);
        return "redirect:/dishes";
    }

    @PostMapping("/edit/{id}")
    public String editDish(@PathVariable Long id,
                           @RequestParam String dishId,
                           @RequestParam String name,
                           @RequestParam String cuisine,
                           @RequestParam int preparationTime) {
        this.dishService.update(id, dishId, name, cuisine, preparationTime);
        return "redirect:/dishes";
    }

    @GetMapping("/delete/{id}")
    public String deleteDish(@PathVariable Long id) {
        this.dishService.delete(id);
        return "redirect:/dishes";
    }

    @PostMapping("/chooseChef")
    public String chooseChef(@RequestParam Long chefId, HttpSession session) {
        session.setAttribute("chefId", chefId);
        return "redirect:/dishes";
    }
}
