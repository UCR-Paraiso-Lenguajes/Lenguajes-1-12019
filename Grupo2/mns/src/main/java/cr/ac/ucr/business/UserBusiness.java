package cr.ac.ucr.business;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.data.UserData;
import cr.ac.ucr.domain.User;

@Service
public class UserBusiness {

	@Autowired
	private UserData userData;
	
	public List<User> findUsers(){
		return userData.findUsers();
	}
	
	public User save(User user) throws SQLException{
		return userData.save(user);
	}

}
