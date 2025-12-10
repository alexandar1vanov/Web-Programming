//package mk.ukim.finki.wp.lab.bootstrap;
//
//import jakarta.annotation.PostConstruct;
//import mk.ukim.finki.wp.lab.model.Chef;
//import mk.ukim.finki.wp.lab.model.Dish;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class DataHolder {
//    public static List<Chef> chefs = new ArrayList<>(5);
//    public static List<Dish> dishes = new ArrayList<>(5);
//
//    @PostConstruct
//    public void init() {
//        // Create some dishes
//        Dish pasta = new Dish("D1", "Creamy Alfredo Pasta", "Makedonska", 12);
//        Dish pizza = new Dish("D2", "Margherita Pizza", "Italian", 10);
//        Dish risotto = new Dish("D3", "Mushroom Risotto", "French", 11);
//        Dish steak = new Dish("D4", "Grilled Ribeye Steak", "German", 20);
//        Dish salad = new Dish("D5", "Greek Salad", "Greek", 8);
//        Dish sushi = new Dish("D6", "Salmon Sushi Roll", "Japan", 13);
//        Dish ramen = new Dish("D7", "Tonkotsu Ramen", "Japan", 14);
//        Dish tacos = new Dish("D8", "Beef Tacos", "Mexico", 9);
//        Dish curry = new Dish("D9", "Chicken Curry", "Indian", 11);
//        Dish burger = new Dish("D10", "Classic Beef Burger", "American", 10);
//        Dish pastramajka = new Dish("D11", "Pastramajka", "Macedonian", 12);
//        Dish klisi = new Dish("D12", "Klisi", "BEROVSKO", 7);
//
//        dishes.addAll(List.of(pasta, pizza, risotto, steak, salad, sushi, ramen, tacos, curry, burger, pastramajka, klisi));
//
//        Chef chef1 = new Chef(
//                1L,
//                "Giovanni",
//                "Rossi",
//                "An Italian chef known for his authentic pasta and risotto dishes.",
//                new ArrayList<>(List.of(pasta, risotto, pizza, klisi))
//        );
//
//        Chef chef2 = new Chef(
//                2L,
//                "Maria",
//                "Sanchez",
//                "A Mexican chef who loves blending traditional flavors with modern techniques.",
//                new ArrayList<>(List.of(tacos, salad, curry))
//        );
//
//        Chef chef3 = new Chef(
//                3L,
//                "Hiro",
//                "Tanaka",
//                "A Japanese sushi master with a passion for fresh and minimalist cuisine.",
//                new ArrayList<>(List.of(sushi, ramen, klisi))
//        );
//
//        Chef chef4 = new Chef(
//                4L,
//                "James",
//                "Carter",
//                "An American grill expert specializing in premium steaks and burgers.",
//                new ArrayList<>(List.of(steak, burger, pastramajka))
//        );
//
//        Chef chef5 = new Chef(
//                5L,
//                "Elena",
//                "Petrova",
//                "A creative Eastern European chef known for her fusion of rustic and modern dishes.",
//                new ArrayList<>(List.of(salad, pasta, steak))
//        );
//
//        chefs.addAll(List.of(chef1, chef2, chef3, chef4, chef5));
//
//    }
//}
