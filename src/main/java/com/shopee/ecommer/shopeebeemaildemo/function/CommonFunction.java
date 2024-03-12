package com.shopee.ecommer.shopeebeemaildemo.function;

import com.shopee.ecommer.shopeebeemaildemo.models.request.AccountsMsgDto;
import com.shopee.ecommer.shopeebeemaildemo.models.request.EmailDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Slf4j
@Configuration
public class CommonFunction {

    @Bean
    public Function<EmailDto, EmailDto> email() {
        return emailDto -> {
            log.info("email:");
            log.info(emailDto.toString());
            emailDto.setContent("transfer text to sms");
            return emailDto;
        };
    }

    @Bean
    public Function<EmailDto, String> sms() {
        return emailDto -> {
            log.info("sms:");
            log.info(emailDto.toString());
            return "send email|sms success";
        };
    }

}
