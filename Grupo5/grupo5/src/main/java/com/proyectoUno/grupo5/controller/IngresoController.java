package com.proyectoUno.grupo5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IngresoController {

    @RequestMapping(value = "/ingreso", method = RequestMethod.GET)
    public String ingreso(Model model){
        return "ingreso";
    }
}

