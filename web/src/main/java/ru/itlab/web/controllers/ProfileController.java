package ru.itlab.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itlab.web.models.User;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/profile")
    public String profileGet(Model model) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null)
            return "redirect:/";

        return "profile.html";
    }
}

