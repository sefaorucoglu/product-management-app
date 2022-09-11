package com.example.ftteknoloji.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String surname;
    @Column(length = 50)
    private String email;
    @Column(length = 15)
    private String phone;
    @OneToMany
    @JoinTable(name="REVIEW_ID")
    private List<ProductReview> reviewId;

}
