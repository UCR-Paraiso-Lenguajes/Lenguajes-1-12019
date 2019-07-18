package com.orbis.B77436.business;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.orbis.B77436.domain.Autor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutorBusinessTest {
	
	@Autowired
	private AutorBusiness autorBusiness;

	@Test
	public void buscarAutores() throws SQLException {
		Iterator<Autor> buscaAutores = autorBusiness.buscarAutores();
		assertNotNull(buscaAutores);
		assertTrue(!buscaAutores.equals(""));
	}
	
}
