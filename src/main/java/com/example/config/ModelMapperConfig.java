package com.example.config;

import com.example.dto.response.ProductReviewResponse;
import com.example.entity.ProductReview;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperConfig {
    private static final Converter<ProductReview, ProductReviewResponse> PRODUCT_REVIEW_PRODUCT_REVIEW_RESPONSE_CONVERTER =
            mappingContext -> {
        var productReview = mappingContext.getSource();
                var productReviewResponse = new ProductReviewResponse();
                productReviewResponse.setProductId(productReview.getProduct().getId());
                productReviewResponse.setUserId(productReview.getUser().getId());
                productReviewResponse.setReview(productReview.getReview());
                productReviewResponse.setDate(productReview.getDate());
                productReviewResponse.setId(productReview.getId());
                return productReviewResponse;
            };
    @Bean
    public ModelMapper getModelMapper () {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(PRODUCT_REVIEW_PRODUCT_REVIEW_RESPONSE_CONVERTER,ProductReview.class,ProductReviewResponse.class);
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
