package com.example.repository;

import com.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface ProductRepository
        extends JpaRepository<Product,Long> {
    List<Product> findProductsByExpirationDateAfter(Date date);


}
