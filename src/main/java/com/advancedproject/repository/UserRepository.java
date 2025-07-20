package com.advancedproject.repository;

import com.advancedproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by username
    Optional<User> findByUsername(String username);

    // Optional: You can also add methods like findByEmail if needed
    // Optional<User> findByEmail(String email);
}
