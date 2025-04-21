package org.fkeller.spring.boot.openapi.gen.service;

import lombok.RequiredArgsConstructor;
import org.fkeller.spring.boot.openapi.gen.client.MessageApi;
import org.fkeller.spring.boot.openapi.gen.mapper.ApiServiceMapper;
import org.fkeller.spring.boot.openapi.gen.service.model.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {

    private final MessageApi messageApi;
    private final ApiServiceMapper apiServiceMapper;

    @Override
    public Message message() {
        ResponseEntity<org.fkeller.spring.boot.openapi.gen.client.model.Message> response = messageApi.messageGet();
        if(response.getStatusCode().is2xxSuccessful()){
            return apiServiceMapper.apiClientMessageToServiceMessage(response.getBody());
        }
        else {
            throw new RuntimeException("Failed to fetch message from API");
        }
    }
}
