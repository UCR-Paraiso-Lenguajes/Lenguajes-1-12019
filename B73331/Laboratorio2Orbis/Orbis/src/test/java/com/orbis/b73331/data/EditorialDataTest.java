package com.orbis.b73331.data;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.orbis.b73331.domain.Editorial;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EditorialDataTest {
	@Autowired //clases externas
	private EditorialData editorialData;
	@Test
	public void buscarPorIdTest() {
		Iterator<Editorial> editorialID = editorialData.buscarPorId(2);
				
		assertTrue(editorialID!=null);
	}
	@Test
	public void buscarPorRangoTest() {
		Iterator<Editorial> editorialRango = editorialData.buscarPorRango(0, 999999);
			
		assertTrue(editorialRango!=null);
	}
}
