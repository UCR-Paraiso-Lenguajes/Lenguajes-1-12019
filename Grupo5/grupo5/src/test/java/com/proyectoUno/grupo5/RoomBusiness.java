package com.proyectoUno.grupo5;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyectoUno.grupo5.business.MetricsBusiness;
import com.proyectoUno.grupo5.business.RoomBussiness;
import com.proyectoUno.grupo5.domain.Room;
import com.proyectoUno.grupo5.domain.User;

@SpringBootTest
public class RoomBusiness {

	@Autowired
	private RoomBussiness roomBusiness;
	
	@Test
	public void test() {
		try
		{
			
			Room room = new Room();
			room.setIdRoom(25);
			room.setRoomName(null);
			try {
				roomBusiness.insertRoom(room);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			assertTrue( false);
		}
		catch (RuntimeException e) 
		{
			assertTrue(  true);
		}
	}

}
