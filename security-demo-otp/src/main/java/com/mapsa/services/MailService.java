package com.mapsa.services;

import com.mapsa.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender mailSender;

    public void sendOtp(User user, String otpContent) throws UnsupportedEncodingException, MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setFrom("mapsa@support.com", "Mapsa");
        helper.setTo(user.getEmail());
        String title = "OTP from Mapsa - Expire in 3hrs!";
        String content = "<div style='background-color:skyblue;'>" +
                "<p> You have requested an OTP, your OTP is <strong>" +
                otpContent + "</strong>. Use it as a password for login.</p>" +
                "</div>";
        helper.setSubject(title);
        helper.setText(content, true);
        mailSender.send(mimeMessage);
    }
}
