package ru.itlab.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itlab.server.service.RandomServiceImpl;

import java.util.Map;

@RestController
public class IntegerController {
    @Autowired
    RandomServiceImpl randomService;

    @RequestMapping("/getIntegers")
    public String test(@RequestParam(name = "min") int min, @RequestParam(name = "max")int max, @RequestParam(name = "count")int count, @RequestParam(name = "replacement")boolean replacement) {
        // if replacement = true => may contain duplicate characters
        return randomService.getInteger(min, max, count, replacement).toString();
    }

}
