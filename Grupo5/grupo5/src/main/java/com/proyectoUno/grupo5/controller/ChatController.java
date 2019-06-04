package com.proyectoUno.grupo5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatController {

        @RequestMapping(value = "/msn", method = RequestMethod.GET)
        public String chatPerUser(@RequestParam("idUser") int idUser){
                return "chat";
        }
}
