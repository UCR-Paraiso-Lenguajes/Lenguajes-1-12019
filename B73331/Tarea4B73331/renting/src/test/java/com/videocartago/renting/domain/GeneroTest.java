package com.videocartago.renting.domain;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videocartago.renting.domain.Genero;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneroTest {
	private Genero genero;
	@Test
	public void generoTest() {
		ArrayList<Genero> generos = new ArrayList<>();
		for (int i = 0; i < generos.size(); i++) {
			genero = new Genero(i, "Genero numero: "+i);
			generos.add(genero);
		}
		for (int i = 0; i < generos.size(); i++) {
			assertTrue(generos.get(i)!=null);
		}
	}
}
