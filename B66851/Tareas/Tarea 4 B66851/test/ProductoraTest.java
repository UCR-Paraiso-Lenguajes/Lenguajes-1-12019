package com.videocartago.renting.domain;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductoraTest {

	
	
	
	@Test
	public void test() {
		
		Productora productora = Productora.getProductora();
		
		List<Object> contenido = new LinkedList<Object>();
		
		productora.setContenido(contenido);
		
	}

}
