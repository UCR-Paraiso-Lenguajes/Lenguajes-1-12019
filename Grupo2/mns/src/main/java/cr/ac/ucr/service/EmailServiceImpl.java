package cr.ac.ucr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {
	
	
    private JavaMailSender javaMailSender;
 
    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender) {
    	this.javaMailSender = javaMailSender;
    }
    
 
    public void sendMail(String to) throws MailException {
       
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setFrom("daniiela.p182@gmail.com");
        message.setSubject("Hola"); 
        message.setText("Se ha enviado el correo");
        javaMailSender.send(message);
   
    }

}
