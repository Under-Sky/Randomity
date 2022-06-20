package ru.itlab.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itlab.web.models.User;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AboutController {
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/about")
    public String aboutGet(Model model) {
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("isGuest", user == null);

        return "about";
    }
}

