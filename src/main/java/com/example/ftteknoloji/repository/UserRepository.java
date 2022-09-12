package com.example.ftteknoloji.repository;

import com.example.ftteknoloji.entity.ProductReview;
import com.example.ftteknoloji.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends JpaRepository<User,Long> {
}
