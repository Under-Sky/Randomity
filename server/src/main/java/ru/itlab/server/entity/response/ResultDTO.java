package ru.itlab.server.entity.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ResultDTO {
    RandomDTO random;
    String bitsUsed;
    String bitsLeft;
    String requestsLeft;
    String advisoryDelay;
}
