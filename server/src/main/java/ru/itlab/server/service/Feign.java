package ru.itlab.server.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itlab.server.entity.request.RequestDTO;
import ru.itlab.server.entity.response.ResponseDTO;

@FeignClient(name = "feign", url = "https://api.random.org")
public interface Feign {
    @RequestMapping(method = RequestMethod.GET, value = "/json-rpc/4/invoke", produces = "application/json")
    ResponseDTO getRandomInteger(@RequestBody RequestDTO requestDTO);
}
