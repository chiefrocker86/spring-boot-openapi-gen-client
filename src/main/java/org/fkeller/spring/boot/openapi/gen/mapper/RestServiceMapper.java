package org.fkeller.spring.boot.openapi.gen.mapper;

import org.fkeller.spring.boot.openapi.gen.service.model.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestServiceMapper {

    Message restMessageToServiceMessage(org.fkeller.spring.boot.openapi.gen.rest.model.Message message);

    org.fkeller.spring.boot.openapi.gen.rest.model.Message serviceMessageToRestMessage(Message message);

}
