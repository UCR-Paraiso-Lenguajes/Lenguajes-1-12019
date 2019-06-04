package com.proyectoUno.grupo5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.proyectoUno.grupo5.domain.User;

@Service
public class NotificationService {

	
	private JavaMailSender javaMailSender;
	
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		
		
		this.javaMailSender = javaMailSender;
	}
	
	
	public void sendNotification(String email, String hash) throws MailException{
		
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setFrom("chatproyectouno@gmail.com");
		mail.setSubject("Prueba de correo chat");
		mail.setText("Bienvenido al chat de CEA adjunto encontrará una URL para ingresar al sitio:" +hash);
		javaMailSender.send(mail);
	}
	
}
