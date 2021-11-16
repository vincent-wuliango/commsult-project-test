package com.commsult.controllers;

import javax.validation.Valid;

import com.commsult.dto.ResponseData;
import com.commsult.dto.UserData;
import com.commsult.models.entities.User;
import com.commsult.services.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    

    @PostMapping("/register")
    public ResponseEntity<ResponseData<User>> register(@Valid @RequestBody UserData userData, Errors errors) { 

        ResponseData<User> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        User user = modelMapper.map(userData, User.class);

        responseData.setStatus(true);
        responseData.setPayload(userService.registerUser(user));
        responseData.getMessages().add(String.format("%s saved", user.getEmail()));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable("id") Long id) {
        return userService.findOne(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<User>> update(@Valid @RequestBody UserData userData, Errors errors) { 

        ResponseData<User> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        User user = modelMapper.map(userData, User.class);

        responseData.setStatus(true);
        responseData.setPayload(userService.registerUser(user));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id) {
        userService.removeOne(id);
    }
}
