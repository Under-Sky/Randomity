package ru.itlab.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itlab.server.service.RandomServiceImpl;

import java.util.Map;

@RestController
public class IntegerController {
    @Autowired
    RandomServiceImpl randomService;

    @RequestMapping("/getIntegers/{min}/{max}/{count}")
    public String test(@PathVariable Map<String, String> pathVarsMap) {
        return randomService.getInteger(Integer.parseInt(pathVarsMap.get("min")), Integer.parseInt(pathVarsMap.get("max")), Integer.parseInt(pathVarsMap.get("count"))).toString();
    }
}
