package com.videocartago.renting.data;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videocartago.renting.dao.GeneroDao;
import com.videocartago.renting.domain.Genero;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneroDataTest {

	@Autowired
	private GeneroDao generoDao;

	@Test
	public void findAll() {
		List<Genero> generos = generoDao.findAllGenres(0,999999999);
		
		assertTrue(generos.get(0).getCodGenero()== 1000);
		assertTrue(generos.get(1).getCodGenero()== 2000);
	}
}
