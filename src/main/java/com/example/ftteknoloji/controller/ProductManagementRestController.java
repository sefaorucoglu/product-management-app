package com.example.ftteknoloji.controller;

import com.example.ftteknoloji.dto.request.FindProductRequest;
import com.example.ftteknoloji.dto.request.FindProductReviewRequest;
import com.example.ftteknoloji.dto.response.FindProductResponse;
import com.example.ftteknoloji.dto.response.FindProductReviewResponse;
import com.example.ftteknoloji.entity.ProductReview;
import com.example.ftteknoloji.exception.ProductNotFoundException;
import com.example.ftteknoloji.exception.ProductReviewNotFoundException;
import com.example.ftteknoloji.service.ProductManagementService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Date;
import java.util.List;

@RequestScope
@RestController
@RequestMapping("/product-management")
@Validated
public class ProductManagementRestController {
    private final ProductManagementService productManagementService;

    public ProductManagementRestController(ProductManagementService productManagementService) {
        this.productManagementService = productManagementService;
    }

    @PostMapping("/getProductReviews")
    public List<FindProductReviewResponse> findProductReviewByProductId (@PathVariable Long id){
        if (id.equals("")){
            throw new ProductReviewNotFoundException("Inputs can not be empty!");
        }
return productManagementService.findProductReviewByProductId(id);
    }
    @PostMapping("/getProductReviewsByProductId")
    public List<FindProductReviewResponse> findProductReviewByDateRangeAndProductId (@RequestBody FindProductReviewRequest request){
        if (request.getProductId().equals("") &&request.getDate().equals("")){
            throw new ProductReviewNotFoundException("Inputs can not be empty!");
        }
        return productManagementService.findProductReviewByDateRangeAndProductId(request);
    }
    @PostMapping("/getProductReviews/{id}")
    public List<FindProductReviewResponse> findProductReviewByUserId (@PathVariable Long id){
        if (id.equals("")){
            throw new ProductReviewNotFoundException("ID can not be empty");
        }
        return productManagementService.findProductReviewByUserId(id);
    }
    @PostMapping("/getProductReviewsByUserId")
    public List<FindProductReviewResponse> findProductReviewByDateRangeAndUserId (@RequestBody FindProductReviewRequest request){
        if (request.getUserId().equals("") &&request.getDate().equals("")){
            throw new ProductReviewNotFoundException("Inputs can not be empty!");
        }
        return productManagementService.findProductReviewByDateRangeAndUserId(request);
    }
    @PostMapping("/getExpiredProducts")
    public List<FindProductResponse> findProductByExpirationAfter (@RequestBody  FindProductRequest request){
        if (request.getExpirationDate().equals("")){
            throw new ProductNotFoundException("Expiration date can not be empty!");
        }
        return productManagementService.findProductByExpirationAfter(request);
    }
    @PostMapping("/getProducts")
    public List<FindProductResponse> findProducts (@RequestBody FindProductRequest request){
        return productManagementService.findProduct(request);
    }


}
