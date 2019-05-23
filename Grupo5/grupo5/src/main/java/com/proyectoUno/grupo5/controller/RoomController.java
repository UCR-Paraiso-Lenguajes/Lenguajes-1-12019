package com.proyectoUno.grupo5.controller;

import com.proyectoUno.grupo5.business.RoomBussiness;
import com.proyectoUno.grupo5.business.UserBussiness;
import com.proyectoUno.grupo5.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.sql.SQLOutput;

@Controller
public class RoomController {
    @Autowired
    private RoomBussiness room;

    @RequestMapping(value = "/insertRoom",method = RequestMethod.GET)
    public String insertRoom(){
        try {
            Room r = new Room("Pelusa",1);
            if (!room.insertRoom(r)) {
                System.out.println("funciono");
            }else{
                System.out.println("no funciono");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "prueba";
    }

}
