package ru.itlab.server.service;

import ru.itlab.server.model.dto.UserCDTO;
import ru.itlab.server.model.dto.UserVDTO;
import ru.itlab.server.util.exception.EmailIsAlreadyExistException;

public interface UserService {
    public UserVDTO registerUser(UserCDTO userCDTO) throws EmailIsAlreadyExistException;
}
