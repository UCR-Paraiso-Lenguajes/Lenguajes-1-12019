package com.videocartago.renting.data;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videocartago.renting.domain.Clip;
import com.videocartago.renting.domain.Pelicula;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClipBusiness {

	@Autowired
	private ClipBusiness clipBusiness;
	
	@Test
	public Clip insertar(Clip clip) {
		assertNotNull(clip);
		return clipBusiness.insertar(clip);
	}

}
