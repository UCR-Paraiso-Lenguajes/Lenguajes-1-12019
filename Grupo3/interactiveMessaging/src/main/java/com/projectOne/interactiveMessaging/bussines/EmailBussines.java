package com.projectOne.interactiveMessaging.bussines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectOne.interactiveMessaging.data.EmailData;
@Service
public class EmailBussines {
	
	@Autowired
	private EmailData emailData;
	
	public void sendMail(String from, String to, String subject, String body) {
		
		emailData.sendMail(from, to, subject, body);
		
	}

}
