package org.fkeller.spring.boot.openapi.gen.rest;

import org.fkeller.spring.boot.openapi.gen.mapper.RestServiceMapper;
import org.fkeller.spring.boot.openapi.gen.service.MessageService;
import org.fkeller.spring.boot.openapi.gen.service.model.Message;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Testing {@link MessageApiDelegateImpl}
 */
@ExtendWith(MockitoExtension.class)
class MessageApiDelegateImplTest {

    @InjectMocks
    private MessageApiDelegateImpl messageApiDelegateImplTest;

    @Mock
    private MessageService messageService;

    @Mock
    private RestServiceMapper restServiceMapper;

    //Welcome to spring-boot-openapi-gen!
    @Test
    void whenMessageThenReturnOK()
            throws Exception {

        String expectedValue = "Welcome to spring-boot-openapi-gen!";
        Message message = new Message();
        message.setValue(expectedValue);
        org.fkeller.spring.boot.openapi.gen.rest.model.Message expectedMessage = new org.fkeller.spring.boot.openapi.gen.rest.model.Message(expectedValue);

        when(messageService.message()).thenReturn(message);
        when(restServiceMapper.serviceMessageToRestMessage(message)).thenReturn(expectedMessage);

        ResponseEntity<org.fkeller.spring.boot.openapi.gen.rest.model.Message> response = messageApiDelegateImplTest.messageGet();
        org.fkeller.spring.boot.openapi.gen.rest.model.Message actualMessage = response.getBody();

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());

        assertNotNull(actualMessage);
        assertEquals(expectedValue, actualMessage.getValue());

    }

}
