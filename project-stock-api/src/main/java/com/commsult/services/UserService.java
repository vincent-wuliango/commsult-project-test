package com.commsult.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.commsult.models.entities.User;
import com.commsult.models.repos.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService implements UserDetailsService{
    
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User registerUser(User user) {
        boolean userExist = userRepo.findByEmail(user.getEmail()).isPresent();

        if(userExist){
            throw new RuntimeException(
                String.format("User with email %s already exist", user.getEmail()));
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        return userRepo.save(user);
    }

    public User findOne(Long id) {
        Optional<User> stock = userRepo.findById(id);
        if(!stock.isPresent()) {
            return null;
        }
        return stock.get();
    }

    public Iterable<User> findAll() {
        return userRepo.findAll();
    }

    public void removeOne(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        return userRepo.findByEmail(email)
        .orElseThrow(() -> 
        new UsernameNotFoundException(String.format("%s not found", email)));
    }
}
