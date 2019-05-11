package com.videocartago.renting.testPatrones;

import static org.junit.Assert.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.videcartago.renting.domain.Pelicula;
import com.videocartago.renting.singleton.Productora;



@RunWith(SpringRunner.class)
@SpringBootTest
public class PatronSingletonTest {
	
	

	@Test
	public void test(){
		Pelicula pelicula = new Pelicula();

		
	
		Productora productora1 = Productora.getInstanceProductora("video prueba 1 ", "clip prueba 1", pelicula);
		Productora productora2 = Productora.getInstanceProductora("video prueba 2", "clip prueba 2", pelicula);
		
		
		Logger.getLogger(getClass().getName()).log(Level.INFO, "clip"+productora1.getClip() + "video" +productora1.getVideo());

		Logger.getLogger(getClass().getName()).log(Level.INFO, "clip"+productora2.getClip() + "video" +productora2.getVideo());

		
	}

}
