package com.example.service;

import com.example.dto.request.ProductRequest;
import com.example.dto.request.ProductReviewRequest;
import com.example.dto.request.UserRequest;
import com.example.dto.response.ProductResponse;
import com.example.dto.response.ProductReviewResponse;
import com.example.dto.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ProductManagementService {
    List<ProductReviewResponse> findProductReviewByProductId (Long id);
    List<ProductReviewResponse> findProductReviewByDateRangeAndProductId (ProductReviewRequest request);
    List<ProductReviewResponse> findProductReviewByUserId (Long id);
    List<ProductReviewResponse> findProductReviewByDateRangeAndUserId (ProductReviewRequest request);
    List<ProductResponse>       findProductByExpirationOver(ProductRequest request);
    List<ProductResponse>       findProduct(ProductRequest request);

    Optional<UserResponse> createUser (UserRequest request);
    Optional<ProductResponse> createProduct (ProductRequest request);
    Optional<ProductReviewResponse> createProductReview (ProductReviewRequest request);


}
