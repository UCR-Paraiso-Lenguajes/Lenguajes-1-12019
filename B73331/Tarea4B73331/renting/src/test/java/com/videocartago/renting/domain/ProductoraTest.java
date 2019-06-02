package com.videocartago.renting.domain;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest

public class ProductoraTest {
	
	private Productora productora = Productora.getInstance();
	
	@Test
	public void productoraTestNoErr()
	{
		productora.setContenido("peliculas");
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, productora.toString());
	
	}
	@Test
	public void productoraTestErr()
	{
		productora.setContenido("imagen");
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, productora.toString());
	
	} 
}
