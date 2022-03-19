package ru.itlab.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.itlab.server.model.dto.random_org_api.request.GenerateIntegersApiDTO;
import ru.itlab.server.model.dto.random_org_api.request.RequestDTO;

import java.util.List;

@Service
public class RandomServiceImpl implements RandomService {
    @Value("${randomorg.api.key}")
    private String apiKey;

    @Autowired
    private Feign feign;

    @Override
    public List<Integer> getInteger(int min, int max, int count, boolean replacement) {
        GenerateIntegersApiDTO generateIntegersApiDTO = new GenerateIntegersApiDTO();
        setUpGenerateIntegersApiDto(generateIntegersApiDTO, min, max, count ,replacement);

        List<Integer> integerList = feign.getRandomInteger(RequestDTO.builder()
                .jsonrpc("2.0")
                .method("generateIntegers")
                .id("1553134")   // TODO making random id for everybody
                .params(generateIntegersApiDTO)
                .build()).getResult().getRandom().getData();
        return integerList;
    }

    private GenerateIntegersApiDTO setUpGenerateIntegersApiDto(GenerateIntegersApiDTO generateIntegersApiDTO, int min, int max, int count, boolean replacement) {
        generateIntegersApiDTO.setMax(max);
        generateIntegersApiDTO.setMin(min);
        generateIntegersApiDTO.setReplacement(replacement);
        generateIntegersApiDTO.setN(count);
        generateIntegersApiDTO.setApiKey(apiKey);
        return generateIntegersApiDTO;
    }
}
