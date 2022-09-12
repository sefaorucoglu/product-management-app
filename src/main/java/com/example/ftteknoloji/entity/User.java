package com.example.ftteknoloji.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
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
    private List<ProductReview> review;

}
