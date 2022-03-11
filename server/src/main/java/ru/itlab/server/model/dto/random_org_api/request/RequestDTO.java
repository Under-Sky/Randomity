package ru.itlab.server.model.dto.random_org_api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RequestDTO {
    String jsonrpc;
    String method;
    GenerateIntegersApiDTO params;
    String id;
}
