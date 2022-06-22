package ru.itlab.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.itlab.server.model.dto.UserVDTO;
import ru.itlab.server.model.entity.User;
import ru.itlab.server.service.UserService;

import javax.annotation.security.PermitAll;
import java.util.UUID;

@RestController
@Slf4j
public class SuccessLoginController {
    @Autowired
    UserService userService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/success/welcome")
    @ResponseBody
    public UserVDTO showProfile() {
        User user;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            user = userService.findByUsername(((UserDetails) principal).getUsername());
        } else {
            user = userService.findByUsername(principal.toString());
        }
        return UserVDTO.fromUser(user);
    }

    @PermitAll
    @ResponseBody
    @GetMapping("/confirm/{uuid}")
    public String confirmAccount(@PathVariable("uuid") UUID id) {
        userService.confirmEmail(id);
        return "confirmed";
    }
}
