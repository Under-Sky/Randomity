package ru.itlab.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itlab.web.models.User;
import ru.itlab.web.models.UserLogin;
import ru.itlab.web.models.UserReg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Controller
public class NavigationController {

    private User user;

    @GetMapping("/reg")
    public String regGet() {
        return "registration.html";
    }

    @PostMapping("/reg")
    public ModelAndView regPost(@ModelAttribute("user") UserReg userReg) {
//        try {
//            URL url = new URL("http://92.255.196.129:8080/login?username=" + userLogin.username + "&password=" + userLogin.password);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("POST");
//            connection.setDoOutput(true);
//
//            InputStream responseStream = connection.getInputStream();
//            ObjectMapper mapper = new ObjectMapper();
//            User responseUser = mapper.readValue(responseStream, User.class);
//
//            System.out.println(responseUser);
//
//            user = responseUser;
//            user.password = userReg.password;
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

        return new ModelAndView("redirect:/");
    }

    @GetMapping("/login")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping("/login")
    public ModelAndView loginPost(@ModelAttribute("user") UserLogin userLogin) {
        try {
            URL url = new URL("http://92.255.196.129:8080/login?username=" + userLogin.username + "&password=" + userLogin.password);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            InputStream responseStream = connection.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            User responseUser = mapper.readValue(responseStream, User.class);

            System.out.println(responseUser);

            user = responseUser;
            user.password = userLogin.password;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return new ModelAndView("redirect:/");
    }

    @GetMapping("/resetPass")
    public String navigateToResetPassword() {
        return "resetPassword.html";
    }

    @GetMapping("/")
    public String mainGet() {
        return "main.html";
    }

    @GetMapping("/getValues")
    @ResponseBody
    public String valuesGet(@RequestParam("min") int min,
                            @RequestParam("max") int max,
                            @RequestParam("count") int count,
                            @RequestParam("replacement") boolean replacement) {
        try {
            URL url = new URL("http://92.255.196.129:8080/getIntegers?min=" + min + "&max=" + max + "&count=" + count + "&replacement=" + replacement);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty(HttpHeaders.AUTHORIZATION, "Basic " + user.authBase64());

            InputStream responseStream = connection.getInputStream();
            String response = new BufferedReader(
                    new InputStreamReader(responseStream, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));

            System.out.println("Response: " + response);

            return response;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return "";
    }
}
