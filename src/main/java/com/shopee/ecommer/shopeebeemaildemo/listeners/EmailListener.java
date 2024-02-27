package com.shopee.ecommer.shopeebeemaildemo.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopee.ecommer.shopeebeemaildemo.models.request.EmailDto;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.groovy.util.StringUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Slf4j
@Component
public class EmailListener {
    public void onMessageReceived(String message) throws JsonProcessingException {
        log.info(message);
        if(!StringUtils.hasLength(message)){
            return;
        }

        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<EmailDto> mapType = new TypeReference<>() {};
        EmailDto payload = objectMapper.readValue(message, mapType);

        if(!ObjectUtils.isEmpty(payload)){
            log.info(payload.toString());
        }
    }
}
