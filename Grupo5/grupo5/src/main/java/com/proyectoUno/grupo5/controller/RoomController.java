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

    @RequestMapping(value = "/createRoom",method = RequestMethod.GET)
    public String insertRoom(){
        return "createroom";
    }

}
