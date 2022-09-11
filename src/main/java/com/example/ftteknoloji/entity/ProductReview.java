package com.example.ftteknoloji.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
public class ProductReview {
    @Id
    private Long id;
    @Column(length = 500)
    private String review;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product productId;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User userId;
}
