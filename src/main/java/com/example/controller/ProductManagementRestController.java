package com.example.controller;

import com.example.dto.request.ProductRequest;
import com.example.dto.request.ProductReviewRequest;
import com.example.dto.request.ReviewAddRequest;
import com.example.dto.request.UserRequest;
import com.example.exception.ProductNotFoundException;
import com.example.exception.ProductReviewNotFoundException;
import com.example.dto.response.ProductResponse;
import com.example.dto.response.ProductReviewResponse;
import com.example.dto.response.UserResponse;
import com.example.service.ProductManagementService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.Optional;

@RequestScope
@RestController
@RequestMapping("/product-management")
@Validated
public class ProductManagementRestController {
    private final ProductManagementService productManagementService;

    public ProductManagementRestController(ProductManagementService productManagementService) {
        this.productManagementService = productManagementService;
    }

    @GetMapping("/getProductReviews/{productId}")
    public List<ProductReviewResponse> findProductReviewByProductId (@RequestParam ProductReviewRequest request){
        if (request.getProductId().equals("")){
            throw new ProductReviewNotFoundException("Inputs can not be empty!");
        }
return productManagementService.findProductReviewByProductId(request.getProductId());
    }
    @GetMapping("/getProductReviewsByProductIdAndDateRange")
    public List<ProductReviewResponse> findProductReviewByDateRangeAndProductId (@RequestBody ProductReviewRequest request){
        if (request.getProductId().equals("") &&request.getDates().isEmpty()==true){
            throw new ProductReviewNotFoundException("Inputs can not be empty!");
        }
        return productManagementService.findProductReviewByDateRangeAndProductId(request);
    }
    @GetMapping("/getProductReviews/{userId}")
    public List<ProductReviewResponse> findProductReviewByUserId (@RequestParam ProductReviewRequest request){
        if (request.getUserId().equals("")){
            throw new ProductReviewNotFoundException("ID can not be empty");
        }
        return productManagementService.findProductReviewByUserId(request.getUserId());
    }
    @GetMapping("/getProductReviewsByUserIdAndDateRange")
    public List<ProductReviewResponse> findProductReviewByDateRangeAndUserId (@RequestBody ProductReviewRequest request){
        if (request.getUserId().equals("") &&request.getDates().isEmpty()==true){
            throw new ProductReviewNotFoundException("Inputs can not be empty!");
        }
        return productManagementService.findProductReviewByDateRangeAndUserId(request);
    }
    @GetMapping("/getExpiredProducts")
    public List<ProductResponse> findProductByExpirationAfter (@RequestBody ProductRequest request){
        if (request.getExpirationDate().equals("")){
            throw new ProductNotFoundException("Expiration date can not be empty!");
        }
        return productManagementService.findProductByExpirationOver(request);
    }
    @GetMapping("/getProducts")
    public List<ProductResponse> findProducts (@RequestBody ProductRequest request){
        return productManagementService.findProduct(request);
    }
    @PostMapping(value = "/addUser")
    public Optional<UserResponse> createUser(@RequestBody UserRequest request){
        return productManagementService.createUser(request);
    }
    @PostMapping(value = "/addProduct")
    public Optional<ProductResponse> createProduct(@RequestBody ProductRequest request){
        return productManagementService.createProduct(request);
    }
    @PostMapping(value = "/addProductReview")
    public Optional<ProductReviewResponse> createProductReview (@RequestBody ReviewAddRequest request){
        return productManagementService.createProductReview(request);
    }


}
