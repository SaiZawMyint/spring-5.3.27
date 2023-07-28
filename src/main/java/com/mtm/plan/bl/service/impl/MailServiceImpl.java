package com.mtm.plan.bl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mtm.plan.bl.service.MailService;
import com.mtm.plan.web.forms.UserForm;

@Service
public class MailServiceImpl implements MailService{
    
    @Autowired
    JavaMailSender mailSender;

    @Override
    public void sendMail(String subject, String body, UserForm user) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject(subject);
        email.setText(body);
        email.setTo(user.getEmail());
        email.setFrom("mtm@gmail.com");
        mailSender.send(email);
    }

}
