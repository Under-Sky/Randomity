package ru.itlab.server.model.dto.random_org_api.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BaseApiDTO {
    String apiKey;
    Integer n;
}
