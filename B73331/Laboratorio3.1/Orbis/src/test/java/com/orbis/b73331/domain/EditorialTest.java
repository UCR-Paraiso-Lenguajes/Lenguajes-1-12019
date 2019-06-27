package com.orbis.b73331.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EditorialTest {
	//@Autowired clases externas
	@Test
	public void test() {
		Editorial editorial1 = new Editorial(1, "La indiscreta", "200 metros Sur del jaja", "25151");
		
		Editorial editorial2 = new Editorial();
		editorial2.setId_editorial(2);
		editorial2.setNombre("La bocera");
		editorial2.setDireccion("400 mts sur de la jijiji");
		editorial2.setTelefono("33333");
		
		assertTrue(editorial1!=null);
		assertTrue(editorial2!=null);
	}
}
