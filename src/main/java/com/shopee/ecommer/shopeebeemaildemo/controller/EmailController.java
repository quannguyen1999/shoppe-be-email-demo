package com.shopee.ecommer.shopeebeemaildemo.controller;

import com.shopee.ecommer.shopeebeemaildemo.service.MailService;
import jakarta.mail.MessagingException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;


@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class EmailController {

    protected final MailService mailService;

    @GetMapping("/email")
    public String email() throws InterruptedException {
        Thread.sleep(10000);
//        try {
//            mailService.sendHtmlMail(Arrays.asList("nguyendanganhquan99@gmail.com"));
//        } catch (MessagingException e) {
//            return "Error in sending email: " + e;
//        }
        return "E-mail sending.....";
    }
}
