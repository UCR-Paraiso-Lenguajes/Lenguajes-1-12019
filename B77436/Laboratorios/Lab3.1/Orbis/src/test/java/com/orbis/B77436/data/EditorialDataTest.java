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
import com.orbis.B77436.domain.Editorial;
import com.orbis.B77436.domain.Libro;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EditorialDataTest {
	@Autowired
	private EditorialData editorialDao;;

	@Test
	public void findEditorials() throws SQLException {
		Iterator<Editorial> buscaEditoriales = editorialDao.findEditorial();
		assertNotNull(buscaEditoriales);
		assertTrue(!buscaEditoriales.equals(""));
	}
	@Test
	public void buscarId() {
		Iterator<Editorial> buscaId = editorialDao.buscarPorId(2);
		assertNotNull(buscaId);
		assertTrue(!buscaId.equals(""));
	}
	@Test
	public void buscarExtracto() {
		Iterator<Editorial> buscaRango = editorialDao.buscarPorExtracto(2, 5);
		assertNotNull(buscaRango);
		assertTrue(!buscaRango.equals(""));
	}
}
