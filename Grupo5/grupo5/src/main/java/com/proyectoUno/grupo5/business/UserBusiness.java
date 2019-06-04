package com.proyectoUno.grupo5.business;

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
}
