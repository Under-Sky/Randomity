package ru.itlab.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itlab.server.model.dto.UserCDTO;
import ru.itlab.server.model.dto.UserVDTO;
import ru.itlab.server.model.entity.User;
import ru.itlab.server.service.UserService;
import ru.itlab.server.util.exception.EmailIsAlreadyExistException;

import javax.annotation.security.PermitAll;

@RestController
@PermitAll
public class RegistrationController {
    @Autowired
    UserService userService;

    @PostMapping("/registration")
    @ResponseBody
    public UserVDTO save(UserCDTO userCDTO) throws EmailIsAlreadyExistException {
        UserVDTO userVDTO = userService.saveUser(userCDTO);
        User user = userService.findByUsername(userVDTO.getUsername());
        userService.sendConfirmEmail(user);
        return userVDTO;
    }
}
