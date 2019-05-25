package com.videocartago.renting.controller;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.videocartago.renting.PeliculaForm;;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertarPeliculaControllerTest {
	
	@Autowired
	private InsertarPeliculaController insertarPeliculaController;
	
	@Test
	public void initTest() {
		PeliculaForm peliculaForm = new PeliculaForm();
		Model model = null;
		assertTrue(insertarPeliculaController.init(peliculaForm, model)!=null);
	}
	
	@Test
	public void save() throws SQLException {
		PeliculaForm peliculaForm = new PeliculaForm();
		BindingResult bindingResult = null;
		Model model = null;
		assertTrue(insertarPeliculaController.save(peliculaForm, bindingResult, model)!=null);
	}

}
