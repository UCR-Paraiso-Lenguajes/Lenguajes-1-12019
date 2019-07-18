package cr.ac.ucr.examenAmpli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PeliculaDespliegueController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String chatPerUser(){
        return "index";
    }
}
