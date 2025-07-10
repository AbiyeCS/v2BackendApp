package com.example.v2BackendApp.repository;

import com.example.v2BackendApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
