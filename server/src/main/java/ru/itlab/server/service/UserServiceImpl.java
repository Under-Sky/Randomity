package ru.itlab.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itlab.server.model.dto.UserCDTO;
import ru.itlab.server.model.dto.UserVDTO;
import ru.itlab.server.model.entity.User;
import ru.itlab.server.repostiry.UserRepository;
import ru.itlab.server.util.exception.EmailIsAlreadyExistException;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public UserVDTO registerUser(UserCDTO userCDTO) throws EmailIsAlreadyExistException {
        userCDTO.setPassword(passwordEncoder.encode(userCDTO.getPassword()));
        User user = userCDTO.toUser();

        Optional<User> userByEmailFromDB = userRepository.getUserByEmail(user.getEmail());
        if(userByEmailFromDB.isPresent()){
            throw new EmailIsAlreadyExistException("An account with the same email was previously created");
        }

        return UserVDTO.fromUser(userRepository.save(user));
    }

}
