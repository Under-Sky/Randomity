package ru.itlab.server.model.dto.random_org_api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.itlab.server.model.dto.random_org_api.base.BaseApiDTO;


@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GenerateIntegersApiDTO extends BaseApiDTO {
    Integer min;
    Integer max;
    Boolean replacement;
}
