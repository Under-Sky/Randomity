package ru.itlab.web.models;

public class UserLogin implements RequestModel {
    public String username;
    public String password;

    public UserLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public String getAttributes() {
        return "username=" + username + "&password=" + password;
    }
}
