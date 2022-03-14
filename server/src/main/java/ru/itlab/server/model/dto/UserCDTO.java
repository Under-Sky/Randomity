package ru.itlab.server.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itlab.server.model.entity.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCDTO {
    private String username;
    private String email;
    private String password;

    public User toUser(){
        return User.builder()
                .username(username)
                .email(email)
                .hashPassword(password)
                .role(User.Role.USER)
                .isConfirmed(false)
                .build();
    }
}
