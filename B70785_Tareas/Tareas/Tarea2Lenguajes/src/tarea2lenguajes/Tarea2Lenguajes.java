/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2lenguajes;

import java.util.ArrayList;

/**
 *
 * @author HP ELITEBOOK
 */
public class Tarea2Lenguajes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Pelicula PeliculaDePruebaUno = new Pelicula("LA VIDA DE PI", "CF0", "CIENCIA FICCION", "ANG LEE", 2012, 500, 127);
    Pelicula PeliculaDePruebaDos = new Pelicula("HASTA EL ULTIMO HOMBRE", "A0", "ACCION", "MEL GIBSON", 2016, 500, 139);
    Pelicula PeliculaDePruebaTres = new Pelicula("IT PARTE 1", "T0", "TERROR", "ANDRES MUSCHIETTI", 2017, 500, 135);
    ArrayList<Pelicula> ListaDeTodasLasPeliculas = new ArrayList<>();
    ListaDeTodasLasPeliculas.add(PeliculaDePruebaUno);
    ListaDeTodasLasPeliculas.add(PeliculaDePruebaDos);
    ListaDeTodasLasPeliculas.add(PeliculaDePruebaTres);
    
    
    
    }
    
}
