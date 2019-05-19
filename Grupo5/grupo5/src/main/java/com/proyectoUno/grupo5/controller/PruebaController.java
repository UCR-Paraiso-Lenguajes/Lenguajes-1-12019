package com.proyectoUno.grupo5.controller;

import com.proyectoUno.grupo5.business.PruebaBusiness;
import com.proyectoUno.grupo5.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PruebaController {

    @Autowired
    private PruebaBusiness prueba;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String insertarLibro(Model model) {
        List<Role> list = prueba.gerRole();
        model.addAttribute("roles", list);
        return "prueba";
    }
}
