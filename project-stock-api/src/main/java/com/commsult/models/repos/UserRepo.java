package com.commsult.models.repos;

import java.util.Optional;

import com.commsult.models.entities.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
}
