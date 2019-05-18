package cr.ac.ucr.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cr.ac.ucr.domain.Role;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleDataTest {

	@Autowired
	private RoleData roleData;
	
	@Test
	public void ListRoles() {
		List<Role> roles = roleData.ListRoles(3);
		assertNotNull(roles);
		assertTrue(!roles.isEmpty());
		assertEquals("Administrador",roles.get(1).getDetail() );
	}

	
}
