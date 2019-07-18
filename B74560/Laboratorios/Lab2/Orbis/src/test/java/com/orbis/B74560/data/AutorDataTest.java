package com.orbis.b73331.data;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.orbis.B74560.data.AutorData;
import com.orbis.B74560.domain.Autor;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AutorDataTest {
	
	@Autowired
	private AutorData autorData;
	
	@Test
	public void encuentraAutoresTest() {
		List<Autor> autores = autorData.buscarAutor(0, 999999);
		assertNotNull(autores);
		assertTrue(!autores.isEmpty());
		
	}
}
