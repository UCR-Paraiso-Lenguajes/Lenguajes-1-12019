package com.projectOne.interactiveMessaging.bussines;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectOne.interactiveMessaging.data.UserData;
import com.projectOne.interactiveMessaging.domain.User;

@Service
public class UserBusiness {
	
	@Autowired
	private UserData userData;
	
	public Iterator<User> findUsersOwnerOrAdmin(int idRoom, int idRole){
		return userData.findUsersOwnerOrAdmin(idRoom, idRole);
	}
	public User getSpecificUserById(int idUser) {
		return userData.getSpecificUserById(idUser);
	}
	
	public Iterator<User> findUsersCertainRoom(int roomID) {
		return findUsersCertainRoom(roomID);
		
	}

}