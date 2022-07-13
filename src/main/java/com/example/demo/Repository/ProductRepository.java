package com.example.demo.Repository;

import com.example.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> , JpaSpecificationExecutor<Product> {
}
