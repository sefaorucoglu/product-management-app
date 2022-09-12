package com.example.ftteknoloji.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductReviewRequest {
    private Long id;
    private Long userId;
    private Long productId;
    private String review;
    private List<Date> dates;
}
