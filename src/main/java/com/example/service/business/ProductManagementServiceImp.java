package com.example.service.business;

import com.example.dto.request.ProductRequest;
import com.example.dto.request.ProductReviewRequest;
import com.example.dto.request.ReviewAddRequest;
import com.example.dto.request.UserRequest;
import com.example.dto.response.ProductResponse;
import com.example.dto.response.ProductReviewResponse;
import com.example.dto.response.UserResponse;
import com.example.entity.Product;
import com.example.entity.ProductReview;
import com.example.entity.User;
import com.example.exception.ProductNotFoundException;
import com.example.exception.ProductReviewNotFoundException;
import com.example.exception.UserNotFoundException;
import com.example.repository.ProductRepository;
import com.example.repository.ProductReviewRepository;
import com.example.repository.UserRepository;
import com.example.service.ProductManagementService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductManagementServiceImp implements ProductManagementService {
    private static final Supplier<ProductNotFoundException> productNotFoundExceptionSupplier =
            () -> new ProductNotFoundException("Product Not Found");
    private static final Supplier<ProductReviewNotFoundException> productReviewNotFoundExceptionSupplier =
            () -> new ProductReviewNotFoundException("Product Review Not Found!");

    private final ProductRepository productRepository;
    private final ProductReviewRepository productReviewRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    @Override
    @Transactional
    public List<ProductReviewResponse> findProductReviewByProductId(Long id) {
        var list = productReviewRepository.findProductReviewByProductId(id)
                .stream()
                .map(productReview -> modelMapper.map(productReview, ProductReviewResponse.class))
                .sorted(Comparator.comparing(ProductReviewResponse::getProductId))
                .toList();
        if (list.isEmpty()) {
            throw productReviewNotFoundExceptionSupplier.get();
        }
        return list;
    }

    @Override
    public List<ProductReviewResponse> findProductReviewByDateRangeAndProductId(ProductReviewRequest request) {
        var list = productReviewRepository.findProductReviewsByDateBetweenAndProductId(
                        request.getDates().get(0), request.getDates().get(1), request.getProductId())
                .stream()
                .map(productReview -> modelMapper.map(productReview, ProductReviewResponse.class))
                .sorted(Comparator.comparing(ProductReviewResponse::getProductId))
                .toList();
        if (list.isEmpty()) {
            throw productReviewNotFoundExceptionSupplier.get();
        }
        return list;
    }


    @Override
    public List<ProductReviewResponse> findProductReviewByUserId(Long id) {
        var list = productReviewRepository.findProductReviewByUserId(id)
                .stream()
                .map(productReview -> modelMapper.map(productReview, ProductReviewResponse.class))
                .sorted(Comparator.comparing(ProductReviewResponse::getUserId))
                .toList();
        if (list.isEmpty()) {
            throw productReviewNotFoundExceptionSupplier.get();
        }
        return list;
    }


    @Override
    public List<ProductReviewResponse> findProductReviewByDateRangeAndUserId(ProductReviewRequest request) {
        var list = productReviewRepository.findProductReviewsByUserIdAndDateBetween(
                        request.getUserId(), request.getDates().get(0), request.getDates().get(1))
                .stream()
                .map(productReview -> modelMapper.map(productReview, ProductReviewResponse.class))
                .sorted(Comparator.comparing(ProductReviewResponse::getUserId))
                .toList();
        if (list.isEmpty()) {
            throw productReviewNotFoundExceptionSupplier.get();
        }
        return list;
    }

    @Override
    public List<ProductResponse> findProductByExpirationOver(ProductRequest request) {
        Date currentDate = new Date();
        var list = productRepository.findProductsByExpirationDateBefore(currentDate)
                .stream()
                .map(product -> modelMapper.map(product, ProductResponse.class))
                .sorted(Comparator.comparing(ProductResponse::getExpirationDate))
                .toList();
        if (list.isEmpty()) {
            throw productNotFoundExceptionSupplier.get();
        }
        return list;
    }

    @Override
    @Transactional
    public List<ProductResponse> findProduct(ProductRequest request) {
        Date currentDate = new Date();
        var list = productRepository.findAll();
        List<Product> filteredProduct = list.stream()
                .filter(product -> product.getExpirationDate().after(currentDate))
                .collect(Collectors.toList());
        list.stream().filter(product -> product.getExpirationDate().equals(null))
                .forEach(product -> filteredProduct.add(product));
        var productResponses = filteredProduct.stream()
                .map(product -> modelMapper.map(product, ProductResponse.class))
                .collect(Collectors.toList());
        return productResponses;

    }

    @Override
    public Optional<UserResponse> createUser(UserRequest request) {
        User user = modelMapper.map(request, User.class);
        return Optional.of(modelMapper.map(userRepository.save(user), UserResponse.class));
    }

    @Override
    public Optional<ProductResponse> createProduct(ProductRequest request) {
        Product product = modelMapper.map(request, Product.class);
        return Optional.of(modelMapper.map(productRepository.save(product), ProductResponse.class));
    }

    @Override
    public Optional<ProductReviewResponse> createProductReview(ReviewAddRequest request) {
        var date = new Date();
        var user =userRepository.findById(request.getUserId()).orElseThrow(()-> new IllegalArgumentException("User not found"));
        var product =productRepository.findById(request.getProductId()).orElseThrow( productNotFoundExceptionSupplier);
        var productReview = new ProductReview();
        productReview.setProduct(product);
        productReview.setUser(user);
        productReview.setDate(date);
        productReview.setReview(request.getReview());
       var savedProductReview= productReviewRepository.save(productReview);
        var productReviewResponse=modelMapper.map(savedProductReview,ProductReviewResponse.class);

      //  ProductReview productReview = modelMapper.map(request, ProductReview.class);
       // return Optional.of(modelMapper.map(productReviewRepository.save(productReview), ProductReviewResponse.class));
        return Optional.of(productReviewResponse);
    }
}