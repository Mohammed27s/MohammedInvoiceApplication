package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("email") //This is the main directory for email api
public class EmailController {

    @Autowired
    EmailService emailService;

    @GetMapping("send") //This is SubDirectory for email
    public void sendSimpleMail(String toEmail, String fromEmail, String emailBody, String subject) {
        emailService.sendSimpleMail(toEmail, fromEmail, emailBody, subject);
    }
}