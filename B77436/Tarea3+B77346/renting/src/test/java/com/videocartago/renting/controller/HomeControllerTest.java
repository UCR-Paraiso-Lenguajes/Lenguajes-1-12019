package com.videocartago.renting.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeControllerTest {
	@Autowired
	private HomeController homeController;
	
	@Test
	public void home() {
		homeController.home();
	}
	
}
