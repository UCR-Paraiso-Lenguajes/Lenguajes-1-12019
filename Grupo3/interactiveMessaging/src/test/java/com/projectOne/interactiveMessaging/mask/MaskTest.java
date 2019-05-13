package com.projectOne.interactiveMessaging.mask;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaskTest {
	
	@Test
	public void assignUserfake() {
		Mask mask = new Mask();
		mask.assignNamesUserfakes();
		ArrayList<String> listOfMember = mask.assignUserfake(10);
		for(int i=0;i<listOfMember.size();i++) {
			assertNotNull(listOfMember.get(i));
		}
	}

}
