package com.proyectoUno.grupo5.business;

import com.proyectoUno.grupo5.dao.RoomDao;
import com.proyectoUno.grupo5.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class RoomBussiness {
    @Autowired
    private RoomDao roomDao;


    public Boolean insertRoom(Room room) throws SQLException {
    	if(room == null) throw new RuntimeException("El room es requerido.");
    	if(room.getRoomName().length() == 0 ) throw new RuntimeException("El nombre es requerido.");
    	return roomDao.insertRoom(room);
    }


	public List<Room> getRooms(int idUser) {
		return roomDao.listRoomsForIdUser(idUser);
	}
 
	public List<Room> getRooms() {
		return roomDao.listRooms();
	}


	public void assignRoom(int id_user) {
		roomDao.assignRoom(id_user);
	}



	

    

}
