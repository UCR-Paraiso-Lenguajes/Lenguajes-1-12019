package com.proyectoUno.grupo5.business;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoUno.grupo5.dao.UserDao;
import com.proyectoUno.grupo5.domain.User;
@Service
public class UserBusiness {
	
    @Autowired
	UserDao userDao;
	
	public Boolean insertUser(User user){
		
		
		return userDao.insertUser(user);
	}
	
	public List<User> getIdUser() {
		
		return userDao.getIdUser();
	}

	public Object getUsers(int id_room) {
		return userDao.getUsers(id_room);
	}
	
	public Boolean invitar(String emails) throws SQLException {
		
		return userDao.invitar(emails);
	}

}
