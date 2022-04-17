package ru.itlab.web.models;

public class UserReg {
    public String username;
    public String email;
    public String password;
    public String password2;

    public UserReg(String username, String email, String password, String password2) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.password2 = password2;
    }

    @Override
    public String toString() {
        return "UserReg{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", password2='" + password2 + '\'' +
                '}';
    }
}
