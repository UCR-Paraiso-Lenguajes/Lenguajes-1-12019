package cr.ac.ucr.business;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.data.UserData;
import cr.ac.ucr.domain.User;
import cr.ac.ucr.exceptions.ProjectExceptions;

@Service
public class UserBusiness {

	@Autowired
	private UserData userData;
	
	public List<User> findUsers(){
		return userData.findUsers();
	}

	public User addUser(User user) throws SQLException, UnsupportedEncodingException {
		if(user == null) throw new ProjectExceptions("El usuario no puede ser nulo");
				
		return userData.save(user);
	}

}
