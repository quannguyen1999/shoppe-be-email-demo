package com.shopee.ecommer.shopeebeemaildemo.service;

import com.shopee.ecommer.shopeebeemaildemo.models.request.EmailDto;
import jakarta.mail.MessagingException;

import java.util.List;

public interface MailService {
    void sendHtmlMail(EmailDto emailDto) throws MessagingException;
}
