package com.example.ftteknoloji.entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Product {
    @Id
    private Long id;
    private String name;
    private Double price;
    @Column(nullable = true)
    private Date expirationDate;
    @OneToMany
    @JoinTable(name="REVIEW_ID")
    private List<ProductReview> reviewId;
}
