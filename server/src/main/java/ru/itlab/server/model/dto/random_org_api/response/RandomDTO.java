package ru.itlab.server.model.dto.random_org_api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RandomDTO {
    List<Integer> data;
    String completionTime;

}
