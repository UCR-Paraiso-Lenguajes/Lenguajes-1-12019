package com.orbis.b73331.business;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.orbis.b73331.data.EditorialData;
import com.orbis.b73331.domain.Editorial;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EditorialBusinessTest {
	@Autowired //clases externas
	private EditorialBusiness editorialBusiness;
	@Test
	public void buscarPorIdTest() {
		Iterator<Editorial> editorialID = editorialBusiness.buscarPorId(2);
				
		assertTrue(editorialID!=null);
	}
	@Test
	public void buscarPorRangoTest1() {
		Iterator<Editorial> editorialRango = editorialBusiness.buscarPorRango(0, 999999);
			
		assertTrue(editorialRango!=null);
	}

	@Test
	public void buscarPorRangoTest2() {
		Iterator<Editorial> editorialRango = editorialBusiness.buscarPorRango(999999, 0);
			
		assertTrue(editorialRango!=null);
	}
}
