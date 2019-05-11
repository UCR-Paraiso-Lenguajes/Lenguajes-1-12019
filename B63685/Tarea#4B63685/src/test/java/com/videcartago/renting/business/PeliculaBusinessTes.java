package com.videcartago.renting.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videcartago.renting.domain.Pelicula;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeliculaBusinessTes 
{
	
	@Autowired
	private PeliculaBusiness peliculaBusiness;
	
	
	@Test
	public void nullInPelicula() 
	{
		try
		{
			Pelicula p = null;
			peliculaBusiness.save(p);
			assertTrue( false);
		}
		catch (RuntimeException e) 
		{
			assertTrue(  true);
		}
	
	}
	
	@Test
	public void InTitlePelicula() 
	{
		try
		{
			Pelicula p = new Pelicula();
			p.setTitulo("eeeeeeuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuueeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
			peliculaBusiness.save(p);
			assertTrue( false);
		}
		catch (RuntimeException e) 
		{
			assertEquals("El nombre no puede tener más de 200 caracteres.", e.getMessage() );
		}
		
	}

}
