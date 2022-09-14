package com.example.dto.request;

import com.example.entity.Product;
import com.example.entity.ProductReview;
import com.example.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewAddRequest {
    private String review;
    private Date date = new Date();

}
