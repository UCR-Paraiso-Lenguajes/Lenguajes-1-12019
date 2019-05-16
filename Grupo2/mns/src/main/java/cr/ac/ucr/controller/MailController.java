package cr.ac.ucr.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cr.ac.ucr.service.EmailServiceImpl;


@RestController
public class MailController {

	private Logger logger = LoggerFactory.getLogger(MailController.class);
	
	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String singupSuccess() {
		
		try {
		emailServiceImpl.sendMail("jeakarlos96@gmail.com");
		}catch(MailException e) {
			logger.info("Error sending Mail: " + e.getMessage());
		}
		return" Gracias por registrarse";
	}
	
}
