package cr.ac.ucr.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;

import cr.ac.ucr.service.EmailServiceImpl;

public class MailController {

	private Logger logger = LoggerFactory.getLogger(MailController.class);
	
	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
	@RequestMapping("/signup")
	public String singupSuccess() {
		
		try {
		emailServiceImpl.sendMail("jeakarlos96@gmail.com");
		}catch(MailException e) {
			logger.info("Error sending Mail: " + e.getMessage());
		}
		return" Gracias por registrarse";
	}
	
}
