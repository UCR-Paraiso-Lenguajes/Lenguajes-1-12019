package com.videocartago.renting.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeliculasControllerTest {
	@Autowired
	private PeliculasController peliculasController;
	
	@Test
	public void iniciar() {
		Model model=null;
		peliculasController.iniciar(model);
	}
	
	@Test
	public void findMovies() {
		Model model=null;
		peliculasController.findMovies(model, "Avatar", "Suspenso3");
	}
}
