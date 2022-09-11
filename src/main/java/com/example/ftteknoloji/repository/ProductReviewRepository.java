package com.example.ftteknoloji.repository;

import com.example.ftteknoloji.entity.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductReviewRepository
        extends JpaRepository<ProductReview,Long> {
    List<ProductReview> findProductReviewsByDateBetweenAndProductId(Date date ,Date date2, Long productId);
    List<ProductReview> findProductReviewsByUserIdAndDateBetween (Long userId , Date date ,Date date2);
}
