package com.example.ftteknoloji.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class FindProductReviewRequest {
    private Long productId;
    private Long userId;
    private List<Date> date;


}
