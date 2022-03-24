package ru.itlab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommonController {

    @Autowired
    RestService restService;

    @GetMapping("/registration")
    public String getSignInPage() {
        return "registration.html";
    }

    @GetMapping("/int")
    @ResponseBody
    public String getInt() {
        return restService.get();
    }
}
