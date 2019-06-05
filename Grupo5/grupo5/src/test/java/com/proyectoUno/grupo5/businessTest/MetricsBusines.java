package com.proyectoUno.grupo5.businessTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyectoUno.grupo5.business.MetricsBusiness;
import com.proyectoUno.grupo5.business.RoomBussiness;
import com.proyectoUno.grupo5.business.UserBusiness;
import com.proyectoUno.grupo5.domain.Room;
import com.proyectoUno.grupo5.domain.User;

@SpringBootTest
public class MetricsBusines {

	@Autowired
	private MetricsBusiness metricsBusiness;
	

	@Autowired
	private UserBusiness userBusiness;
	
	@Autowired
	private RoomBussiness roomBusiness;
	
	@Test
	public void test() {
		try
		{
			User user = new User();
			user.setIdUser(25);
			user.setEmail("esteban5678@gmail.com");
			userBusiness.insertUser(user);
			Room room = new Room();
			room.setIdRoom(25);
			room.setRoomName("test");
			try {
				roomBusiness.insertRoom(room);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			roomBusiness.assignRoom(user.getIdUser());
			
			
			
			
			metricsBusiness.delete(room.getIdRoom(), user.getIdUser());
			assertTrue( false);
		}
		catch (RuntimeException e) 
		{
			assertTrue(  true);
		}
	}

}
