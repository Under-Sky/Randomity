package ru.itlab.server.service;

import ru.itlab.server.model.dto.GeneratorCDTO;
import ru.itlab.server.model.dto.GeneratorVDTO;
import ru.itlab.server.model.dto.UserCDTO;
import ru.itlab.server.model.dto.UserVDTO;
import ru.itlab.server.model.entity.Generator;
import ru.itlab.server.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface GeneratorService {
    List<GeneratorVDTO> getGeneratorsByUser(User user);

    GeneratorVDTO saveGenerator(GeneratorCDTO generatorCDTO);

    List<Generator> getAllGenerators();

    Generator getGeneratorById(Long id);
}
