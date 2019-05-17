package com.videocartago.renting.business;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videocartago.renting.domain.Genero;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneroBusinessTest {
	@Autowired
	private GeneroBusiness generoBusiness;
	@Test
	public void findAllTest() {
		List<Genero> generos = generoBusiness.findAll(0, 99999999);
		
		assertTrue(  generos.get(0).getCodGenero() == 1000);
		assertTrue(  generos.get(1).getCodGenero() == 2000);
	}
}
