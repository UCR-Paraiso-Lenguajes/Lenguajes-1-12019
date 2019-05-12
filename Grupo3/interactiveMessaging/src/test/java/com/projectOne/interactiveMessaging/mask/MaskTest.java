package com.projectOne.interactiveMessaging.mask;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.projectOne.interactiveMessaging.tda.QueueException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaskTest {
	
	@Test
	public void assignUserfake() {
		Mask mask = new Mask();
		mask.assignNamesUserfakes();
		for(int i =0;i<50;i++) {
			assertNotNull(mask.assignUserfake());
		}
	}
	
	@Test
	public void removeUserfake() throws QueueException {
		Mask mask = new Mask();
		mask.assignNamesUserfakes();
		
		//asignar un userfake 1
		assertEquals("Frodo", mask.assignUserfake());
		
		//asignar un userfake 2
		assertEquals("Darth Vader", mask.assignUserfake());
		
		//asignar un userfake 3
		assertEquals("Luke", mask.assignUserfake());;
		
		//remueve un userfake
		mask.removeUserFake("Frodo");
		
		//asignar un userfake 4
		assertEquals("Frodo", mask.assignUserfake());
		
		//asignar un userfake 5
		assertEquals("Pantera Rosa", mask.assignUserfake());
		
		
	}

}
