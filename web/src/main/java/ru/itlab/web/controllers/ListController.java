package ru.itlab.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itlab.web.models.Generator;
import ru.itlab.web.models.User;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class ListController {
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/list")
    public String generatorsListGet(Model model) {
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("isGuest", user == null);

        return "list";
    }

    @GetMapping("/get_gens")
    @ResponseBody
    public String someGensGet() {
        try {
            URL url = new URL("http://92.255.196.129:8080/generators");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);

            InputStream responseStream = connection.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            Generator[] resp = mapper.readValue(responseStream, Generator[].class);

            StringBuilder json = new StringBuilder();
            json.append("[");
            for (int i = 0; i < resp.length; i++) {
                if (i != 0) json.append(",");

                json.append(resp[i].toJSON());
            }
            json.append("]");
            return json.toString();
        } catch (IOException e) {
            System.out.println("Custom error: " + e.getMessage());
        }

        return "";
    }
}

