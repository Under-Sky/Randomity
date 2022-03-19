package ru.itlab.server.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itlab.server.model.entity.Generator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GeneratorVDTO {
    private Long id;
    private String nameOfGenerator;

    public static GeneratorVDTO fromGenerator(Generator generator){
        return GeneratorVDTO.builder()
                .id(generator.getId())
                .nameOfGenerator(generator.getNameOfGenerator())
                .build();
    }
}
