package ru.itlab.web.models;

public class UserReset implements RequestModel {
    public String email;

    public UserReset(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserReset{" +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public String getAttributes() {
        return "email=" + email;
    }
}
