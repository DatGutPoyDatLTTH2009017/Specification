package com.example.demo;

import com.example.demo.Repository.ProductRepository;
import com.example.demo.entity.Product;
import com.example.demo.search.ProductSpecification;
import com.example.demo.search.SearchCriteria;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShoppingApplication.class)
public class ProductSpecificationTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    public void demoTest() {
        ProductSpecification filter01 =
                new ProductSpecification(new SearchCriteria("name", "=", "Braden Farrell"));
        ProductSpecification filter02 =
                new ProductSpecification(new SearchCriteria("price", ">", "10000"));
        ProductSpecification filter03 =
                new ProductSpecification(new SearchCriteria("price", "<=", "15000"));


        List<Product> orders = productRepository.findAll(filter02.and(filter03));
        System.out.println(orders.size());
    }
}