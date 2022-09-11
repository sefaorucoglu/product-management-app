package com.example.ftteknoloji.repository;

import com.example.ftteknoloji.entity.Product;
import com.example.ftteknoloji.entity.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductRepository
        extends JpaRepository<Product,Long> {
    List<Product> findProductsByExpirationDateAfter(Date date);


}
