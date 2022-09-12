package com.example.repository;

import com.example.entity.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface ProductReviewRepository
        extends JpaRepository<ProductReview,Long> {
    List<ProductReview> findProductReviewsByDateBetweenAndProductId(Date date ,Date date2, Long productId);
    List<ProductReview> findProductReviewsByUserIdAndDateBetween (Long userId , Date date ,Date date2);
}
