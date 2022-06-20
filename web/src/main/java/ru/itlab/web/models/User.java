package ru.itlab.web.models;

import java.util.Base64;

public class User {
    public String username;
    public String email;
    public String role;
    public String password;
    public boolean isConfirmed;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", isConfirmed=" + isConfirmed +
                '}';
    }

    public String authBase64() {
        return Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }
}
