package com.orbis.B77436.data;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.orbis.B77436.business.LibroBusiness;
import com.orbis.B77436.domain.Autor;
import com.orbis.B77436.domain.Libro;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutorDataTest {
	@Autowired
	private AutorData autorDao;

	@Test
	public void find() throws SQLException {
		Iterator<Autor> buscaLibro = autorDao.findAutores();
		assertNotNull(buscaLibro);
		assertTrue(!buscaLibro.equals(""));
	}
}
