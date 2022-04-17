package ru.itlab.web;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class RestService {

    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String get() {
        String url = "https://92.255.196.129:8080/getIntegers?min=0&max=10&count=10&replacement=false";
        String str = Arrays.toString(this.restTemplate.getForObject(url, Integer[].class));
        System.out.println(str);

        return str;
        //ResponseEntity<Post> response = this.restTemplate.getForEntity(url, Post.class, 1);
        //if(response.getStatusCode() == HttpStatus.OK) {
        //      return response.getBody();
        //} else {
        //      return null;
        //}
    }
}
