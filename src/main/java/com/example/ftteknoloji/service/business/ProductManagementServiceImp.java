package com.example.ftteknoloji.service.business;
import com.example.ftteknoloji.dto.request.ProductRequest;
import com.example.ftteknoloji.dto.request.ProductReviewRequest;
import com.example.ftteknoloji.dto.request.UserRequest;
import com.example.ftteknoloji.dto.response.ProductResponse;
import com.example.ftteknoloji.dto.response.ProductReviewResponse;
import com.example.ftteknoloji.dto.response.UserResponse;
import com.example.ftteknoloji.exception.ProductNotFoundException;
import com.example.ftteknoloji.exception.ProductReviewNotFoundException;
import com.example.ftteknoloji.exception.UserNotFoundException;
import com.example.ftteknoloji.repository.ProductRepository;
import com.example.ftteknoloji.repository.ProductReviewRepository;
import com.example.ftteknoloji.repository.UserRepository;
import com.example.ftteknoloji.service.ProductManagementService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class ProductManagementServiceImp implements ProductManagementService {
    private static  final Supplier<ProductNotFoundException> productNotFoundExceptionSupplier =
            () ->new ProductNotFoundException("Product Not Found");
    private static  final Supplier<ProductReviewNotFoundException> productReviewNotFoundExceptionSupplier =
            () ->new ProductReviewNotFoundException("Product Review Not Found");
    private static  final Supplier<UserNotFoundException> userNotFoundExceptionSupplier =
            () ->new UserNotFoundException("User Not Found");
    private final ProductRepository productRepository;
    private final ProductReviewRepository productReviewRepository;
    private final UserRepository userRepository;

    public ProductManagementServiceImp(ProductRepository productRepository, ProductReviewRepository productReviewRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.productReviewRepository = productReviewRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<ProductReviewResponse> findProductReviewByProductId(Long id) {
        return null;
    }

    @Override
    public List<ProductReviewResponse> findProductReviewByDateRangeAndProductId(ProductReviewRequest request) {
        return null;
    }

    @Override
    public List<ProductReviewResponse> findProductReviewByUserId(Long id) {
        return null;
    }

    @Override
    public List<ProductReviewResponse> findProductReviewByDateRangeAndUserId(ProductReviewRequest request) {
        return null;
    }

    @Override
    public List<ProductResponse> findProductByExpirationAfter(ProductRequest request) {
        return null;
    }

    @Override
    public List<ProductResponse> findProduct(ProductRequest request) {
        return null;
    }

    @Override
    public Optional<UserResponse> createUser(UserRequest request) {
        return Optional.empty();
    }

    @Override
    public Optional<ProductResponse> createProduct(ProductRequest request) {
        return Optional.empty();
    }

    @Override
    public Optional<ProductReviewResponse> createProductReview(ProductReviewRequest request) {
        return Optional.empty();
    }
}