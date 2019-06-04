package com.proyectoUno.grupo5.controller;

import com.proyectoUno.grupo5.business.RoleBusiness;
import com.proyectoUno.grupo5.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class RoleController {

    @Autowired
    private RoleBusiness prueba;
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public String insertarLibro(Model model) {
        int id =1;
        List<Role> list = prueba.gerRolePerId(id);
        System.out.println(list.isEmpty());
        model.addAttribute("roles", list);
        return "prueba";
    }
}
