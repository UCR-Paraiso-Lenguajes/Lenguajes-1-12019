package com.videcartago.renting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
   //mapea el html en la ruta
    @RequestMapping(value="/home", method=RequestMethod.GET)
    public String home(){
        return "helloworld";
    }
}

