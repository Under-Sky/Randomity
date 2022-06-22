package ru.itlab.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itlab.web.models.User;
import ru.itlab.web.models.UserReg;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class RegController {
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
            URL url = new URL("http://localhost:8080/registration?" + userReg.getAttributes());
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
}
