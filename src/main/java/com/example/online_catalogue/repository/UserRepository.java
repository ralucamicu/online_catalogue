package com.example.online_catalogue.repository;

import com.example.online_catalogue.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
