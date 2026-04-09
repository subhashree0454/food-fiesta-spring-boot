package com.example.demo.config;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                Product p1 = new Product();
                p1.setPname("Hyderabadi Chicken Biryani");
                p1.setPprice(350.0);
                p1.setPdescription("Authentic long-grain basmati rice cooked with tender chicken and secret spices.");

                Product p2 = new Product();
                p2.setPname("Paneer Butter Masala");
                p2.setPprice(280.0);
                p2.setPdescription("Rich and creamy cottage cheese cubes served in a velvet tomato gravy.");

                Product p3 = new Product();
                p3.setPname("Chicken Tikka Tandoori");
                p3.setPprice(320.0);
                p3.setPdescription("Smoky charcoal-grilled chicken marinated in yogurt and traditional tandoori tikka masala.");

                Product p4 = new Product();
                p4.setPname("Veg Manchurian");
                p4.setPprice(220.0);
                p4.setPdescription("Savory vegetable balls tossed in a tangy and spicy oriental soy-based sauce.");

                Product p5 = new Product();
                p5.setPname("Gulab Jamun (2pcs)");
                p5.setPprice(120.0);
                p5.setPdescription("Warm, soft milk-solid dumplings dipped in fragrant cardamom-infused sugar syrup.");

                repository.saveAll(List.of(p1, p2, p3, p4, p5));
                System.out.println("Sample products data seeded into database.");
            }
        };
    }
}
