package ru.itlab.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itlab.server.service.RandomServiceImpl;

@RestController
public class IntegerController {
    @Autowired
    RandomServiceImpl randomService;

    @RequestMapping("/")
    public String test(){
        return randomService.getInteger(0,10, 5).toString();
    }
}
