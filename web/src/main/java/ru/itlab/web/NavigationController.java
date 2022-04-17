package ru.itlab.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itlab.web.models.User;
import ru.itlab.web.models.UserLogin;
import ru.itlab.web.models.UserReg;
import ru.itlab.web.models.UserReset;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/reg")
    public String regGet() {
        return "registration.html";
    }

    @PostMapping("/reg")
    public String regPost(@ModelAttribute("user") UserReg userReg) {
        if (!userReg.password.equals(userReg.password2))
            return "registration.html";

        try {
            URL url = new URL("http://92.255.196.129:8080/registration?" + userReg.getAttributes());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            InputStream responseStream = connection.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            User responseUser = mapper.readValue(responseStream, User.class);

            System.out.println(responseUser);
            System.out.println("Response Status: " + connection.getResponseMessage());

            User user = responseUser;
            user.password = userReg.password;
            request.getSession().setAttribute("user", user);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping("/login")
    public String loginPost(@ModelAttribute("user") UserLogin userLogin) {
        try {
            URL url = new URL("http://92.255.196.129:8080/login?" + userLogin.getAttributes());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            InputStream responseStream = connection.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            User responseUser = mapper.readValue(responseStream, User.class);

            System.out.println(responseUser);
            System.out.println("Response Status: " + connection.getResponseMessage());

            User user = responseUser;
            user.password = userLogin.password;
            request.getSession().setAttribute("user", user);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return "redirect:/";
    }

    @GetMapping("/resetPass")
    public String resetPasswordGet() {
        return "resetPassword.html";
    }

    @PostMapping("/resetPass")
    public String resetPasswordPost(@ModelAttribute UserReset userReset) {
        try {
            URL url = new URL("http://92.255.196.129:8080/reset?" + userReset.getAttributes());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            InputStream responseStream = connection.getInputStream();
            String response = new BufferedReader(
                    new InputStreamReader(responseStream, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));

            System.out.println("Response Status: " + connection.getResponseMessage());
            System.out.println("Response: " + response);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return "resetPasswordFinish.html";
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
        User user = (User) request.getSession().getAttribute("user");

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

            System.out.println("Response Status: " + connection.getResponseMessage());
            System.out.println("Response: " + response);

            return response;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return "";
    }
}
