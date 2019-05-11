package com.videocartago.renting.controller;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.videocartago.renting.form.PeliculaForm;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertarPeliculaControllerTest {
	
	@Autowired
	private InsertarPeliculaController insertarPeliculaController;
	
	@Test
	public void init() {
		PeliculaForm peliculaForm = new PeliculaForm();
		Model model = null;
		insertarPeliculaController.init(peliculaForm, model);
	}
	
	@Test
	public void save() throws SQLException {
		PeliculaForm peliculaForm = new PeliculaForm();
		BindingResult bindingResult = null;
		Model model = null;
		insertarPeliculaController.save(peliculaForm, bindingResult, model);
	}

}
