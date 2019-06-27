package com.orbis.b73331.business;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.orbis.b73331.domain.Autor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutorBusinessTest {
	@Autowired
	private AutorBusiness autorBusiness;
	@Test
	public void encuentraAutores() {
		List<Autor> autores = autorBusiness.encuentraAutores(0, 999999);
		assertNotNull(autores);
		assertTrue(!autores.isEmpty());
	}
}
