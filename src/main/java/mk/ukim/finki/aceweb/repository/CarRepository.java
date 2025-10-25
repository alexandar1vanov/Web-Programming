package mk.ukim.finki.aceweb.repository;

import mk.ukim.finki.aceweb.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("select c from Car as c order by c.brand asc ")
    List<Car> getAllOrderedAlphabetically();

    List<Car> getCarsByBrandOrderByBrandAsc(String brandName);

    List<Car> getCarsByYear(int year);
}
