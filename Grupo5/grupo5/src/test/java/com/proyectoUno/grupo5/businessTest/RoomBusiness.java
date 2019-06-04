package com.proyectoUno.grupo5.businessTest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proyectoUno.grupo5.business.RoomBussiness;
import com.proyectoUno.grupo5.domain.Room;
import com.proyectoUno.grupo5.domain.User;

public class RoomBusiness {

	
	@Autowired
	RoomBussiness roomBusiness;
	
	@Test
	public void test() throws SQLException {
		
		User user = new User();
		ArrayList<User> users = new ArrayList<>();
		users.add(user);
		
		try
		{
			Room room = new Room();
			room.setIdRoom(1);
			room.setRoomName("Los teletubies");
			room.setVersion(1);
			
			room.setUsers(users);
			
			try {
				roomBusiness.insertRoom(room);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			roomBusiness.insertRoom(room);	
			
			
			assertTrue( false);
		}
		catch (RuntimeException e) 
		{
			assertTrue(  true);
		}
	}
	@Test
	public void validaRooms() throws SQLException {
		
		User user = new User();
		ArrayList<User> users = new ArrayList<>();
		users.add(user);
		
		try
		{
			Room room = new Room();
			room.setIdRoom(1);
			room.setRoomName("Los teletubies");
			room.setVersion(1);
			
			room.setUsers(users);
			
			try {
				roomBusiness.insertRoom(room);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			roomBusiness.insertRoom(room);	
			
			
			assertTrue( false);
		}
		catch (RuntimeException e) 
		{
			assertTrue(  true);
		}
	}
	
	@Test
	public void roles() {
		
		
		User user = new User();
		ArrayList<User> users = new ArrayList<>();
		users.add(user);
		
		try
		{
			Room room = new Room();
			room.setIdRoom(1);
			room.setRoomName("Los teletubies");
			room.setVersion(1);
			
			room.setUsers(users);
			
			try {
				roomBusiness.insertRoom(room);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			roomBusiness.insertRoom(room);	
			
			
			assertTrue( false);
		}
		catch (RuntimeException e) 
		{
			assertTrue(  true);
		}
	}
	
	
		
	}
	

