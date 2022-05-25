package ru.itlab.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

        switch (genId) {
            case 1:
                model.addAttribute("design", "unity/coinDesign.html");
                model.addAttribute("code", "unity/coinCode.html");
                break;
            case 2:
                model.addAttribute("design", "unity/colorDesign.html");
                model.addAttribute("code", "unity/colorCode.html");
                break;
            case 3:
                model.addAttribute("design", "unity/fortunaDesign.html");
                model.addAttribute("code", "unity/fortunaCode.html");
                break;
        }

        return "randomDetails";

        /*try {
            URL url = new URL("http://92.255.196.129:8080/generators/my");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty(HttpHeaders.AUTHORIZATION, "Basic " + user.authBase64());

            InputStream responseStream = connection.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            Generator[] resp = mapper.readValue(responseStream, Generator[].class);

            System.out.println(resp);

            boolean hasAccess = false;
            for (Generator g : resp) {
                if(g.id == genId){
                    hasAccess = true;
                    System.out.println(g.id + " " + g.nameOfGenerator);
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
}