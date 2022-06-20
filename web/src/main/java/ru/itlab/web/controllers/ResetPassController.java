package ru.itlab.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
public class ResetPassController {
    @Autowired
    private HttpServletRequest request;

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
}
