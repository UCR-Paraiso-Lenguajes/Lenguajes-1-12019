package cr.ac.ucr.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cr.ac.ucr.domain.Role;
import cr.ac.ucr.domain.User;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDataTest {

	@Autowired
	private UserData userData;
	
	@Test 
	public void save() {
		User savedUser;
		savedUser = userData.create(getUser());

		List<User> userListFromDb = userData.findUsers();
		
		
		for (User user : userListFromDb) {
				if(user.getHash().equals(savedUser.getHash())) {
		
					assertEquals(savedUser.getHash(), user.getHash());
					assertEquals(savedUser.getEmail(), user.getEmail());
				}
		}
	}
	
	
	 private User getUser() {
			User user = new User();
			user.setEmail("johndoe@gmail.com");
			user.setHash("ksjdbhvnmAMLoeiwahusdb2345ydfsdas");
			return user;
	}
	
	
}
