package com.videocartago.renting.data;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videocartago.renting.domain.Pelicula;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovimientoDataTest {
	@Autowired
	private MovimientoData movimientoData;
	
	@Test
	public void determinaEstado(int codPelicula) {
		codPelicula=3;
		
		String estado = movimientoData.determinaEstado(codPelicula);
		assertNotNull(estado);
	}
	
	@Test
	public void colocaEstado() {
		String titulo="Lyka";	
		movimientoData.colocarEstado(titulo, true);
	}
}
