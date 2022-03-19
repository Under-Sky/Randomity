package ru.itlab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

    @GetMapping("/registration")
    public String getSignInPage() {
        return "registration.html";
    }
}
