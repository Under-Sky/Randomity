package ru.itlab.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itlab.web.models.User;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class GeneratorController {
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/gen")
    public String mainGet(Model model, @RequestParam("id") int genId) {
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("isGuest", user == null);

        model.addAttribute("genPath", "/coinFlipIndex.html");
        return "randomDetails";

        /*try {
            URL url = new URL("http://92.255.196.129:8080/generators/my");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            InputStream responseStream = connection.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            Generator[] resp = mapper.readValue(responseStream, Generator[].class);

            System.out.println(resp);

            boolean hasAccess = false;
            for (Generator g : resp) {
                if(g.id == genId){
                    hasAccess = true;
                    break;
                }
            }
            if(hasAccess){
                model.addAttribute("genId", genId);
                return "randomDetails";
            }
        } catch (IOException e) {
            System.out.println("Custom error: " + e.getMessage());
        }

        return "redirect:/error";*/
    }

    public class Generator {
        public int id;
        public String nameOfGenerator;

        public Generator() {
        }
    }
}