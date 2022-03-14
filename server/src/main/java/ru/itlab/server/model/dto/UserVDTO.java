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
public class UserVDTO {
    private String username;
    private String email;
    private User.Role role;
    private Boolean isConfirmed;

    public static UserVDTO fromUser(User user){
        return UserVDTO.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .role(user.getRole())
                .isConfirmed(user.getIsConfirmed())
                .build();
    }
}