package com.videcartago.renting.domain;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeliculaFactoryTest {
	PeliculaFactory peliculaFactory=new PeliculaFactory("", "", 1, "", 1, false, false,new Genero(1,"terror"), new LinkedList<Actor>());
	
	@Test
	public void test() {
		peliculaFactory.clasificar();
		assertNotNull(peliculaFactory.getClasificacion());
		

	}

}
