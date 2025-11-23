package mk.ukim.finki.aceweb.services;

import mk.ukim.finki.aceweb.model.Car;
import mk.ukim.finki.aceweb.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public List<Car> getAllCarsSortedByBrandAlphabetically() {
        return repository.getAllOrderedAlphabetically();
    }

    public List<Car> getCarsByBrandOrderByBrandAsc(String brandName) {
        return repository.getCarsByBrandOrderByBrandAsc(brandName);
    }

    public List<Car> getCarsByYear(int year) {
        return repository.getCarsByYear(year);
    }
}
