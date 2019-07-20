package cr.ac.ucr.examenAmpli.controller;

import cr.ac.ucr.examenAmpli.business.PeliculaBusiness;
import cr.ac.ucr.examenAmpli.domain.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("peliculas")
public class PeliculaController {

    @Autowired
  PeliculaBusiness peliculas;
    @CrossOrigin(origins = "http://localhost:8080/peliculas/")
    @RequestMapping(value="/", method= RequestMethod.GET)
    public ResponseEntity<Object> getRooms() {

        return new ResponseEntity<>(peliculas.cargarPeliculas(), HttpStatus.OK);


    }
}
