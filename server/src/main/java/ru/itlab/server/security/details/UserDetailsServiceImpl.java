package ru.itlab.server.security.details;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itlab.server.model.entity.User;
import ru.itlab.server.repostiry.UserRepository;


@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Loading user details username  is {}", username);
        User user =
                userRepository
                        .getUserByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new UserDetailsImpl(user);
    }
}
