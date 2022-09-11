package com.example.ftteknoloji.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindProductReviewResponse {
    private Long id;
    private String review;
    private Date date;
    private Long ProductId;
    private Long userId;
}
