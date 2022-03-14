package ru.itlab.server.service;

import ru.itlab.server.model.dto.UserCDTO;
import ru.itlab.server.model.dto.UserVDTO;
import ru.itlab.server.model.entity.User;
import ru.itlab.server.util.exception.EmailIsAlreadyExistException;

import java.util.UUID;

public interface UserService {
    UserVDTO registerUser(UserCDTO userCDTO) throws EmailIsAlreadyExistException;

    void sendConfirmEmail(User user);

    void confirmEmail(UUID uuid);

    User findByUsername(String username);
}
