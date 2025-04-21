package org.fkeller.spring.boot.openapi.gen.rest;

import lombok.RequiredArgsConstructor;
import org.fkeller.spring.boot.openapi.gen.mapper.RestServiceMapper;
import org.fkeller.spring.boot.openapi.gen.rest.model.Message;
import org.fkeller.spring.boot.openapi.gen.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageApiDelegateImpl implements MessageApiDelegate {

    private final MessageService messageService;
    private final RestServiceMapper restServiceMapper;

    public ResponseEntity<Message> messageGet() {

        return ResponseEntity.ok(restServiceMapper.serviceMessageToRestMessage(messageService.message()));

    }

}
