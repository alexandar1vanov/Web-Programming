package mk.ukim.finki.aceweb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="brand")
    private String brand;

    @Column(name="model")
    private String model;

    @Column(name="year")
    private int year;

    @Column(name="price")
    private Long price;

    @Column(name="km")
    private Long kilometers;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setKilometers(Long kilometers) {
        this.kilometers = kilometers;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public Long getKilometers() {
        return kilometers;
    }

    public String getModel() {
        return model;
    }

    public Long getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }
}
