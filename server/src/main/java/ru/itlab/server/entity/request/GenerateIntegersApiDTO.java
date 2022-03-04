package ru.itlab.server.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.itlab.server.entity.base.BaseApiDTO;


@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GenerateIntegersApiDTO extends BaseApiDTO {
    Integer min;
    Integer max;
}
