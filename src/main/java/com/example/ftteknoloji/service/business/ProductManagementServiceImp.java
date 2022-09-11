package com.example.ftteknoloji.service.business;
import com.example.ftteknoloji.dto.request.FindProductRequest;
import com.example.ftteknoloji.dto.request.FindProductReviewRequest;
import com.example.ftteknoloji.dto.response.FindProductResponse;
import com.example.ftteknoloji.dto.response.FindProductReviewResponse;
import com.example.ftteknoloji.entity.Product;
import com.example.ftteknoloji.service.ProductManagementService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductManagementServiceImp implements ProductManagementService {
    @Override
    public List<FindProductReviewResponse> findProductReviewByProductId(Long id) {
        return null;
    }

    @Override
    public List<FindProductReviewResponse> findProductReviewByDateRangeAndProductId(FindProductReviewRequest request) {
        return null;
    }

    @Override
    public List<FindProductReviewResponse> findProductReviewByUserId(Long id) {
        return null;
    }

    @Override
    public List<FindProductReviewResponse> findProductReviewByDateRangeAndUserId(FindProductReviewRequest request) {
        return null;
    }

    @Override
    public List<FindProductResponse> findProductByExpirationAfter(FindProductRequest request) {
        return null;
    }

    @Override
    public List<FindProductResponse> findProduct(FindProductRequest request) {
        return null;
    }
}