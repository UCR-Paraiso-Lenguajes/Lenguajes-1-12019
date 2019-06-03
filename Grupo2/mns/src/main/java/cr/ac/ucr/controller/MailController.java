package cr.ac.ucr.controller;


import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cr.ac.ucr.business.UserBusiness;
import cr.ac.ucr.domain.User;
import cr.ac.ucr.exceptions.ProjectExceptions;
import cr.ac.ucr.form.UserForm;
import cr.ac.ucr.service.EmailServiceImpl;


@RestController
public class MailController {

	@Autowired
	private UserBusiness userBusiness;
	
	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String singupSuccess() {
		return "start";
	}
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String createRoom(Model model,UserForm userForm)  {
		
		
		User user = new User();
		user.setEmail(userForm.getEmail());
		try {
			user.setHash(Base64.getEncoder().encodeToString(user.getEmail().getBytes("UTF-8")));
			userBusiness.addUser(user);
		} catch (SQLException | UnsupportedEncodingException e) {
			throw new ProjectExceptions(e);
		} 
		
		
		emailServiceImpl.sendMail(user);
		
		
		return "chat";
	}
}
