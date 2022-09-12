package com.example.ftteknoloji.repository;

import com.example.ftteknoloji.entity.Product;
import com.example.ftteknoloji.entity.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface ProductRepository
        extends JpaRepository<Product,Long> {
    List<Product> findProductsByExpirationDateAfter(Date date);


}
