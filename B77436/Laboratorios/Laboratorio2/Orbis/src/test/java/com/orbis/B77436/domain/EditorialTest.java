package com.orbis.B77436.domain;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EditorialTest {

	
	@Test
	public void probarEditorial() {
		Editorial editorial = new Editorial();
		editorial.setId_editorial(1001);
		editorial.setNombre("Palneta");
		editorial.setDireccion("Cartago");
		editorial.setTelefono("2222222");
		editorial.getId_editorial();
		editorial.getNombre();
		editorial.getDireccion();
		editorial.getTelefono();
		assertNotNull(editorial);
		assertTrue(!editorial.equals(""));
	}
}
