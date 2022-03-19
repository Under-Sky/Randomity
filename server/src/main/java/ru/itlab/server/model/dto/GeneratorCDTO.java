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
public class GeneratorCDTO {
    private String nameOfGenerator;

    public Generator toGenerator(){
        return Generator.builder()
                .nameOfGenerator(nameOfGenerator)
                .build();
    }
}
