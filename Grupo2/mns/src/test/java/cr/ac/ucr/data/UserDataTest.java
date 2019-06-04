package cr.ac.ucr.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cr.ac.ucr.domain.User;
import cr.ac.ucr.exceptions.ProjectExceptions;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDataTest {

	@Autowired
	private UserData userData;
	
	@Test 
	public void save() {
		User savedUser = new User();
		savedUser = getUser(); 
		
		try {
			userData.save(savedUser);
		} catch (SQLException e) {
			throw new ProjectExceptions(e);
		}

		List<User> userListFromDb = userData.findUsers();
		assertTrue(!userListFromDb.isEmpty());
		
		for (User user : userListFromDb) {
				if(user.getIdUser() == savedUser.getIdUser()) {
		
					assertEquals(savedUser.getHash(), user.getHash());
					assertEquals(savedUser.getEmail(), user.getEmail());
				}
		}
	}
	
	
	 private User getUser() {
			User user = new User();
			user.setIdUser(1009);
			user.setEmail("johndoe@gmail.com");
			user.setHash("ksjdbhvn");
			return user;
	}
	
	
}
