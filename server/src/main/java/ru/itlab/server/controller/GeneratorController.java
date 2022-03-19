package ru.itlab.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.itlab.server.model.dto.GeneratorCDTO;
import ru.itlab.server.model.dto.GeneratorVDTO;
import ru.itlab.server.model.dto.UserCDTO;
import ru.itlab.server.model.entity.Generator;
import ru.itlab.server.model.entity.User;
import ru.itlab.server.service.GeneratorService;
import ru.itlab.server.service.UserService;

import javax.annotation.security.PermitAll;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/generators")
public class GeneratorController {

    @Autowired
    private GeneratorService generatorService;
    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/my")
    @ResponseBody
    public List<GeneratorVDTO> getGeneratorsForUser(){
        User user = userService.findByUsername(getUsername());

        return generatorService.getGeneratorsByUser(user);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/new")
    @ResponseBody
    public GeneratorVDTO createNewGenerator(GeneratorCDTO generatorCDTO){
        return generatorService.saveGenerator(generatorCDTO);
    }

    @PermitAll
    @GetMapping("")
    @ResponseBody
    public List<GeneratorVDTO> getAllGenerators(){
        List<GeneratorVDTO> generatorsVDTO = new ArrayList<>();
        for (Generator g: generatorService.getAllGenerators()) {
            generatorsVDTO.add(GeneratorVDTO.fromGenerator(g));
        }
        return generatorsVDTO;
    }

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/buy")
    @ResponseStatus(value = HttpStatus.OK)
    public void buyGenerator(@RequestParam(name = "idOfGenerator")Long idOfGenerator){
        User user = userService.findByUsername(getUsername());

        user.getGenerators().add(generatorService.getGeneratorById(idOfGenerator));
        userService.updateUser(user);
    }

    private String getUsername(){
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }

}
