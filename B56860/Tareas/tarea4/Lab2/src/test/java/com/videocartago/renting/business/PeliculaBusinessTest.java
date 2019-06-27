package com.videocartago.renting.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videocartago.renting.domain.Pelicula;
import com.videocartago.renting.domain.Stock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeliculaBusinessTest {

	@Autowired
	private PeliculaBusiness peliculaBusiness;
	
	@Test
	public void inNullPeli() {
		try {
			Pelicula p = null;
			peliculaBusiness.save(p);
		} catch (SQLException e) {
			assertTrue(true);
		}
		
	}

	@Test
	public void inTitlePeli() {
		try {
			Pelicula p = new Stock();
			p.setTitulo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeerrrrrrrrrrrrrrrrrrrrrrrrr");
			peliculaBusiness.save(p);
		} catch (SQLException e) {
			assertEquals("El nombre no puede tener + de 200 caracteres", e);
		}
		
	}
}
