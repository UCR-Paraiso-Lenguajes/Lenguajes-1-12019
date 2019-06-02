package com.proyectoUno.grupo5.business;

import com.proyectoUno.grupo5.dao.RoomDao;
import com.proyectoUno.grupo5.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class RoomBussiness {
    @Autowired
    private RoomDao roomDao;


    public Boolean insertRoom(Room room) throws SQLException {
        return roomDao.insertRoom(room);
    }
 
    pubic 

}
