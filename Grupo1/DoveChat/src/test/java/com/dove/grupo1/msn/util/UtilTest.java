package com.dove.grupo1.msn.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilTest {

 @Autowired
 MailService emailService;


 @Test
 public void getUsersNamesArrayList() {
  ArrayList<String> usersNames = Utilities.getUsersNamesArrayList();
  assertNotNull(usersNames);
  assertTrue(usersNames.size() == 50);
  assertTrue(!usersNames.get(37).equals("") && usersNames.get(12) != null);
 }
 
 @Test
 public void sendEmail() {
  emailService.sendEmail("no-reply@dovechat.com", "meli8538@gmail.com","Prueba","Funcional");
 
 }
}

	
	

