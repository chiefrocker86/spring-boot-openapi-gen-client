package org.fkeller.spring.boot.openapi.gen.mapper;

import org.fkeller.spring.boot.openapi.gen.client.model.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApiServiceMapper {

    Message serviceMessageToApiClientMessage(org.fkeller.spring.boot.openapi.gen.service.model.Message message);

    org.fkeller.spring.boot.openapi.gen.service.model.Message apiClientMessageToServiceMessage(Message message);

}
