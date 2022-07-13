package com.example.demo.seeder;

import com.example.demo.Repository.ProductRepository;
import com.example.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class ProductSeeder implements CommandLineRunner {
    @Autowired
    ProductRepository productRepository;
    private static final int NUMBER_OF_PRODUCT = 100;
    public static ArrayList<Product> products;

    public void generate(){
        ArrayList<String>colos = new ArrayList<>();
        colos.add("red");
        colos.add("white");
        colos.add("yellow");
        colos.add("blue");
        colos.add("green");
        ArrayList<String>sizes = new ArrayList<>();
        sizes.add("XL");
        sizes.add("S");
        sizes.add("M");
        ArrayList<String>genders = new ArrayList<>();
        genders.add("Male");
        genders.add("FeMale");
        genders.add("Other");
        Random random = new Random();
        Fake fake = new Fake();
        products = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_PRODUCT; i++){
            Product obj = Product.builder()
                    .name(fake.name().name())
                    .description(fake.name().title())
                    .gender(genders.get(NumberHelper.numberRandom(0, genders.size() - 1)))
                    .color(colos.get(NumberHelper.numRandom(0, colos.size()-1)))
                    .size(sizes.get(NumberHelper.numRandom(0, sizes.size()-1)))
                    .price(NumberHelper.numberRandom(10000,100000))
                    .status(NumberHelper.numberRandom(0,1))
                    .createdAt(LocalDateTime.now().minusDays(NumberHelper.numberRandom(1,30)))
                    .build();
            products.add(obj);
        }
        productRepository.saveAll(products);
    }
    @Override
    public void run(String... args) throws Exception {
        generate();
    }
}
