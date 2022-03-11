package ru.itlab.server.model.dto.random_org_api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ResponseDTO {
    String jsonrpc;
    ResultDTO result;
    String id;
}
