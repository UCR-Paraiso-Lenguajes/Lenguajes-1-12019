package com.projectOne.interactiveMessaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projectOne.interactiveMessaging.bussines.GroupBusiness;

@SpringBootApplication//main
public class InteractiveMessagingApplication {
	
	
	public static void main(String[] args) {
		//GroupBusiness gbBusiness = new GroupBusiness();
		//gbBusiness.chargeUserGroupTable();
		SpringApplication.run(InteractiveMessagingApplication.class, args);
	}

}
