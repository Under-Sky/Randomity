package ru.itlab.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itlab.web.models.User;

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
public class APIController {

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/getValues")
    @ResponseBody
    public String valuesGet(@RequestParam("min") int min,
                            @RequestParam("max") int max,
                            @RequestParam("count") int count,
                            @RequestParam("replacement") boolean replacement) {
        User user = (User) request.getSession().getAttribute("user");

        if (user != null) {
            try {
                URL url = new URL("http://localhost:8080/getIntegers?min=" + min + "&max=" + max + "&count=" + count + "&replacement=" + replacement);
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
            } catch (Exception e) {
                System.out.println("eee: " + e.getMessage());
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < count; i++) {
            if (i != 0) builder.append(",");

            int ans = ((int) Math.round(Math.random() * (max - min))) + min;
            builder.append(ans);
        }
        builder.append("]");
        return builder.toString();
    }
}
