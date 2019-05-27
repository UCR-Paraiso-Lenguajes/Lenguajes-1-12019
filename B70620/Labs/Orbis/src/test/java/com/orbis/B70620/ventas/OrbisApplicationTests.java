package com.orbis.B70620.ventas;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.orbis.B70620.ventas.data.AutorData;
import com.orbis.B70620.ventas.data.LibroData;
import com.orbis.B70620.ventas.domain.Autor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrbisApplicationTests {

	@Autowired
	private AutorData autorData;
	
	@Test
	public void contextLoads() {
		ArrayList<Autor> autores = (ArrayList<Autor>) autorData.obtenerAutoresPorApellidos("Santa");
		assertNotNull(autores);
			
	}

}
