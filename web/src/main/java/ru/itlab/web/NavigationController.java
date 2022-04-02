package ru.itlab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

    @GetMapping("/reg")
    public String navigateToRegistration() {
        return "registration.html";
    }

    @GetMapping("/login")
    public String navigateToLogin() {
        return "login.html";
    }

    @GetMapping("/resetPass")
    public String navigateToResetPassword() {
        return "resetPassword.html";
    }
}
