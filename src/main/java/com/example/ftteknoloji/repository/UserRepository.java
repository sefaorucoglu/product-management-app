package com.example.ftteknoloji.repository;

import com.example.ftteknoloji.entity.ProductReview;
import com.example.ftteknoloji.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User,Long> {
}
