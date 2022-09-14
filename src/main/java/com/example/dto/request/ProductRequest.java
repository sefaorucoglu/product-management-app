package com.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private String name;
    @Nullable
    private Double price;
    private Date expirationDate;
}
