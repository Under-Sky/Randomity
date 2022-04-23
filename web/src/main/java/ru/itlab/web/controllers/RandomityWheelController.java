package ru.itlab.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RandomityWheelController {
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/randomityWheel")
    public String randomityWheelGet(){
        return "randomityWheel.html";
    }
}
