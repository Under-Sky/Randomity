package ru.itlab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommonController {

    @Autowired
    RestService restService;

    @GetMapping("/int")
    @ResponseBody
    public String getInt() {
        return restService.get();
    }
}
