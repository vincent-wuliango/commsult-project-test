package com.commsult.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.commsult.dto.ResponseData;
import com.commsult.dto.UserRequest;
import com.commsult.dto.UserResponse;
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
@RequestMapping("/api/v1")
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/users")
    public ResponseEntity<ResponseData<List<UserResponse>>> getAllUsers() {
        ResponseData<List<UserResponse>> responseData = new ResponseData<>();
        List<UserResponse> listUser = new ArrayList<>();
        userService.findAll().forEach(user -> {
            listUser.add(modelMapper.map(user, UserResponse.class));
        });
        responseData.setStatus(true);
        responseData.setPayload(listUser);
        return ResponseEntity.ok(responseData);
    }
    // public List<User> getAllUsers() {
    //     return userService.findAll();
    // }

    @GetMapping("/users/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping("/users/register")
    public ResponseEntity<ResponseData<User>> register(@Valid @RequestBody UserRequest userRequest, Errors errors) { 

        ResponseData<User> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        User user = modelMapper.map(userRequest, User.class);

        responseData.setStatus(true);
        responseData.setPayload(userService.registerUser(user));
        responseData.getMessages().add(String.format("%s saved", user.getEmail()));
        return ResponseEntity.ok(responseData);
    }

    @PutMapping("/users/update")
    public ResponseEntity<ResponseData<User>> update(@Valid @RequestBody UserRequest userRequest, Errors errors) { 

        ResponseData<User> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        User user = modelMapper.map(userRequest, User.class);

        responseData.setStatus(true);
        responseData.setPayload(userService.registerUser(user));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/users/delete/{id}")
    public void removeOne(@PathVariable("id") Long id) {
        userService.removeById(id);
    }
}
