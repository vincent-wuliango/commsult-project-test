package com.commsult.models.repos;

import java.util.Optional;

import com.commsult.models.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
}
