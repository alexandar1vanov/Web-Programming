package mk.ukim.finki.aceweb.controller;

import mk.ukim.finki.aceweb.model.Car;
import mk.ukim.finki.aceweb.services.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {

    private final CarService service;

    CarController(CarService service) {
        this.service = service;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return service.getAllCarsSortedByBrandAlphabetically();
    }

    @GetMapping("/brand")
    public List<Car> getCarsByBrand(@RequestParam String brandName) {
        return service.getCarsByBrandOrderByBrandAsc(brandName);
    }

    @GetMapping("/yearManufactured/{year}")
    public List<Car> getCarsByYearManufactured(@PathVariable int year) {
        return service.getCarsByYear(year);
    }


}
