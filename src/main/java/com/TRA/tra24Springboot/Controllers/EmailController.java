package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email") //This is the main directory for email
public class EmailController {

    @Autowired
    EmailService emailService; //This is for saving the get request

    @GetMapping("send") //This is for sending email
    public void sendSimpleMail(String toEmail, String fromEmail, String emailBody, String subject) {
        try {
            emailService.sendSimpleMail(toEmail, fromEmail, emailBody, subject);
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to send email", e);
        }
    }
}
