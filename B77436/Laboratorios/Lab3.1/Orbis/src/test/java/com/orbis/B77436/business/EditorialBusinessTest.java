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

import com.orbis.B77436.domain.Editorial;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EditorialBusinessTest {

	@Autowired
	private EditorialBusiness editoBusiness;
	
	
	@Test
	public void buscarId() {
		Iterator<Editorial> buscaEditorial = editoBusiness.buscarId(1);
		assertNotNull(buscaEditorial);
		assertTrue(!buscaEditorial.equals(""));
	}
	
	@Test
	public void buscarExracto() {
		Iterator<Editorial> buscaExtracto = editoBusiness.buscarExtrato(1, 4);
		assertNotNull(buscaExtracto);
		assertTrue(!buscaExtracto.equals(""));
	}
	
	@Test
	public void buscarIdsEditorial() throws SQLException {
		Iterator<Editorial> buscaEditorial = editoBusiness.findIdsEditorial();
		assertNotNull(buscaEditorial);
		assertTrue(!buscaEditorial.equals(""));
	}
	
}
