package ru.itlab.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itlab.web.models.User;
import ru.itlab.web.models.UserLogin;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class LoginController {

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/login")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping("/login")
    public String loginPost(@ModelAttribute("user") UserLogin userLogin) {
        try {
            URL url = new URL("http://localhost:8080/login?" + userLogin.getAttributes());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            InputStream responseStream = connection.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            User responseUser = mapper.readValue(responseStream, User.class);

            System.out.println(responseUser);
//            System.out.println("Response Status: " + connection.getResponseMessage());

            User user = responseUser;
            user.password = userLogin.password;
            request.getSession().setAttribute("user", user);
        } catch (IOException e) {
            System.out.println("Custom error: " + e.getMessage());
        }

        return "redirect:/";
    }
}
