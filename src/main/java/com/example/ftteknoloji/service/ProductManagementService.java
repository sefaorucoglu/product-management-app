package com.example.ftteknoloji.service;

import com.example.ftteknoloji.dto.request.FindProductRequest;
import com.example.ftteknoloji.dto.request.FindProductReviewRequest;
import com.example.ftteknoloji.dto.response.FindProductResponse;
import com.example.ftteknoloji.dto.response.FindProductReviewResponse;
import com.example.ftteknoloji.entity.Product;

import java.util.List;

public interface ProductManagementService {
    List<FindProductReviewResponse> findProductReviewByProductId (Long id);
    List<FindProductReviewResponse> findProductReviewByDateRangeAndProductId (FindProductReviewRequest request);
    List<FindProductReviewResponse> findProductReviewByUserId (Long id);
    List<FindProductReviewResponse> findProductReviewByDateRangeAndUserId (FindProductReviewRequest request);
    List<FindProductResponse>       findProductByExpirationAfter(FindProductRequest request);
    List<FindProductResponse>       findProduct(FindProductRequest request);


}
