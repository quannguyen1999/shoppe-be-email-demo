package com.shopee.ecommer.shopeebeemaildemo.service.impl;

import com.shopee.ecommer.shopeebeemaildemo.models.request.EmailDto;
import com.shopee.ecommer.shopeebeemaildemo.service.MailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Service
public class MailImpl implements MailService {
    @Value("${spring.mail.username}")
    private String USERNAME;

    protected final JavaMailSender mailSender;
    protected final SpringTemplateEngine templateEngine;


    @Override
    public void sendHtmlMail(EmailDto emailDto) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        Context context = new Context();
        context.setVariable("username", USERNAME);
        context.setVariable("logo", "logo");
        String process = templateEngine.process("email_html.html", context);
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());
        helper.setTo(emailDto.getToUsers().toArray(new String[0]));
        helper.setFrom(new InternetAddress(USERNAME));
        helper.setSubject("HTML email from Spring Boot");
        helper.setText(process, true);
        helper.addInline("logo", new ClassPathResource("static/Logo.png"));
        helper.addAttachment("spring_boot.txt", new ClassPathResource("static/spring_boot.txt"));
        mailSender.send(message);
    }
}
