package ru.itlab.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itlab.server.model.dto.GeneratorCDTO;
import ru.itlab.server.model.dto.GeneratorVDTO;
import ru.itlab.server.model.entity.Generator;
import ru.itlab.server.model.entity.User;
import ru.itlab.server.repostiry.GeneratorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GeneratorServiceImpl implements GeneratorService{
    @Autowired
    private GeneratorRepository generatorRepository;

    @Override
    public List<GeneratorVDTO> getGeneratorsByUser(User user) {
        List<GeneratorVDTO> generatorsVDTO = new ArrayList<>();
        for (Generator g:generatorRepository.findAllByUsers(user)) {
            generatorsVDTO.add(GeneratorVDTO.fromGenerator(g));
        }
        return generatorsVDTO;
    }

    @Override
    public GeneratorVDTO saveGenerator(GeneratorCDTO generatorCDTO) {
        Generator generator = generatorCDTO.toGenerator();

        return GeneratorVDTO.fromGenerator(generatorRepository.save(generator));
    }

    @Override
    public List<Generator> getAllGenerators() {
        return generatorRepository.findAll();
    }

    @Override
    public Generator getGeneratorById(Long id) {
        return generatorRepository.getById(id);
    }
}
