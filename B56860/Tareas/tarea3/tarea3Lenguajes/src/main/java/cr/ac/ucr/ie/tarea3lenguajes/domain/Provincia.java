package cr.ac.ucr.ie.tarea3lenguajes.domain;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel
 */
public class Provincia implements Ciudad {    //Cap 6 Abstracción de datos.
                                              //    Se abstrae parte de la información mas generalizadalo que intenta es tener una
                                              //    implementación menos concreta y evitando setters y getters innecesarios y con esto
    private static int demografíaTotal=0;     //    se quiere llegar a representar los datos de la mejor manera, dependiendo del caso.
    private List<Persona> personas;           
    
    
    @Override
    public int getPoblacionTotal() {
        return demografíaTotal;
    }

    @Override
    public void agregarCiudadanos(int id, char genero) {
        try {
            personas.add(demografíaTotal, new Persona(id, genero)); 
            demografíaTotal++;                                                          //Cap 7 Ecribe el Try-Catch-Finally primero
        } catch (Exception ex) {                                                        //Evitar inconsistencias en las cuales por ejemplo 
            Logger.getLogger(Provincia.class.getName()).log(Level.SEVERE, null, ex);    //se lleva a cabo una instruccion (en este caso demografíaTotal++;)     
        }                                                                               //se mete dentro del try por que puede que afecte el flujo de los datos
    }                                                                                   //si es ejecutada y unas líneas después se "cae" el programa
    
}
