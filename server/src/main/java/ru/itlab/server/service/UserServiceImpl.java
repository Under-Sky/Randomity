package ru.itlab.server.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itlab.server.model.dto.UserCDTO;
import ru.itlab.server.model.dto.UserVDTO;
import ru.itlab.server.model.entity.TechnicalInfo;
import ru.itlab.server.model.entity.User;
import ru.itlab.server.repostiry.UserRepository;
import ru.itlab.server.util.exception.EmailIsAlreadyExistException;
import ru.itlab.server.util.smtp.EmailUtil;
import ru.itlab.server.util.smtp.MailsGenerator;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MailsGenerator mailsGenerator;
    @Autowired
    private EmailUtil emailUtil;

    @Value("${server.url}")
    private String serverUrl;
    @Value("${spring.mail.username}")
    private String from;

    @Transactional
    public UserVDTO registerUser(UserCDTO userCDTO) throws EmailIsAlreadyExistException {
        userCDTO.setPassword(passwordEncoder.encode(userCDTO.getPassword()));
        User user = userCDTO.toUser();
        user.setTechnicalInfo(TechnicalInfo.builder()
                .user(user)
                .uuidToConfirm(UUID.randomUUID())
                .build()
        );

        Optional<User> userByEmailFromDB = userRepository.getUserByEmail(user.getEmail());
        if(userByEmailFromDB.isPresent()){
            throw new EmailIsAlreadyExistException("An account with the same email was previously created");
        }

        return UserVDTO.fromUser(userRepository.save(user));
    }

    @Override
    public void sendConfirmEmail(User user) {
        String confirmMail =
                mailsGenerator.getEmailforConfirm(serverUrl, user.getTechnicalInfo().getUuidToConfirm());
        emailUtil.sendEmail(user.getEmail(), "Confirm Account", from, confirmMail);
    }

    @Override
    public void confirmEmail(UUID uuid) {
        User user =
                userRepository
                        .findByTechnicalInfo_UuidToConfirmEquals(uuid)
                        .orElseThrow(() -> new EntityNotFoundException("There is no user to confirm email"));
        user.setIsConfirmed(Boolean.TRUE);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.getUserByUsername(username).get();
    }

}
