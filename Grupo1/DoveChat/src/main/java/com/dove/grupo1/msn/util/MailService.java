package com.dove.grupo1.msn.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


public class MailService {

	@Autowired
    private JavaMailSender mailSender;
 
    
    public void sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("");
        message.setTo("josue.ad.95@gmail.com");
        message.setSubject("Prueba");
        message.setText("Talvez funcione");
        mailSender.send(message);
    }
}
