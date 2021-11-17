package com.commsult.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserRequest {
    
    @NotEmpty(message = "Username is required")
    @NotNull(message = "Username is required")
    private String username;

    @NotEmpty(message = "Password is required")
    @NotNull(message = "Password is required")
    private String password;
    
    @NotEmpty(message = "Email is required")
    @NotNull(message = "Email is required")
    @Email(message = "Email not valid")
    private String email;

    @NotEmpty(message = "User Role is required")
    @NotNull(message = "User Role is required")
    private String userRole;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    
}
