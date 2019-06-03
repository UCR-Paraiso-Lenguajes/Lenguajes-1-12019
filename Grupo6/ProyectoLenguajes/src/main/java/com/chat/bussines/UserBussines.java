package com.chat.bussines;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Service;

import com.chat.data.UserData;
import com.chat.domain.UserClient;
import com.ram.configuration.AppConfig;
import com.ram.service.MailService;
import com.ram.service.MailServiceImpl;

@Service
public class UserBussines {
	
	@Autowired
	UserData userData;
	
	private String names[] = {"Insecure","Nervous","Tense","Anxious","Angry","Confused","Weak","Petrified","Tense","Horrified",
	"Inadequate","Flat","Motivade","Surprised","Satisfied","Upset","Miserable","Sad","Foolish","Discontented",
	"Wonderful","Proud","Energetic","Hopeful","Loving","Lonely","Mixep-Up","Surprised","Weepy","Tearful",
	"Miserable","Shocked","Frustrated","Disgust","Anger","Amusement","Distress","Embarrassment","sympathy"};
	
	String[] animals = { "bee", "eagle", "spider", "wasp", "whale", "bison", "buffalo", "donkey", "horse", "camel",
			"canary", "crab", "kangaroo", "snail", "zebra", "pig", "chimpanzee", "deer", "swan", "crocodile",
			"elephant", "beetle", "scorpion", "seal", "hen", "cock", "cat", "swallow", "hippopotamus", "ant",
			"wild boar", "giraffe", "lion", "parrot", "fly", "mosquito", "bear", "sheep", " partridge", "dog",
			"penguin", "chick", "grasshoppers", "snake", "tiger", "mole", "bull", "turtle", "cow", "fox" };
	
	public boolean createUserValidation(UserClient user) {	
		
		boolean value=true;
		
		if(user == null) {
	
			value=false;
			
			throw new RuntimeException("El user es requerido");
			
		}
				
		return value;
	}
	
	public UserClient SetParametters(UserClient user) {
		
		
Random r = new Random();
		
		int min=0;
		int max=49;
		
		int valueAnimal = r.nextInt((max - min) + 1) + min;
		int valueNames  = r.nextInt((max - min) + 1) + min;
		int valueAvatar  = r.nextInt((max - min) + 1) + min;
	
		String userFake = names[valueNames]+" "+animals[valueAnimal];
		String avatar= "/img/img"+valueAvatar;
		
		user.setName(userFake);
		user.setAvatar(avatar); 
		
		return user;
	}
	
	public void sendEmail(UserClient user, int idRoom) {
		
	

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		MailService mailService = context.getBean("mailService", MailServiceImpl.class);

		String senderEmailId = "lenguajesaplicaciones@gmail.com";
		String receiverEmailId = user.getEmail();
		String subject = "Invitación";
		String message = "http://localhost:8585/mainScreen/"+user.getEmail()+"/"+idRoom;

		mailService.sendEmail(senderEmailId, receiverEmailId, subject, message);
		context.close();
		
	}
	
	

}
