package cr.ac.ucr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import cr.ac.ucr.domain.User;

@Service
public class EmailServiceImpl {
	
	
    private JavaMailSender javaMailSender;
 
    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender) {
    	this.javaMailSender = javaMailSender;
    }
    
 
    public void sendMail(User user) throws MailException {
       
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(user.getEmail()); 
        message.setFrom("priscipo@gmail.com");
        message.setSubject("Proyecto 1 Lenguajes Link de entrada"); 
        message.setText("localhost:8080/chat/"+user.getHash());
        javaMailSender.send(message);
   
    }

}
