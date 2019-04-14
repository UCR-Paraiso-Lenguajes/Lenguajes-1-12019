package com.videocartago.renting.Iterator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
public class MovimientAgregadoConcreto implements MovimientoAgregado
{
     protected Vector aDatos = new Vector();
 
    public MovimientAgregadoConcreto() {
        
    }
  
    @Override
     public Iterador getIterador()
    {
        return new IteradorConcreto( this );
    }
    
    
    public String obtenerFechaActual() {
    	Date date = new Date();
    	
    	DateFormat hourFormat = new SimpleDateFormat("dd/MM/yyyy");
    	return " Fecha: " +hourFormat.format(date);
    	
    }
    
    public String obtenerHoraActual() {
    	Date date = new Date();
    	
    	DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
    	return " Hora: " +hourFormat.format(date);
    	
    }
    
    public void llenar(String Tipo, String Pelicula)
    {
    	
        this.aDatos.add( new String( Tipo + ';'
        		+ Pelicula + ';' + obtenerHoraActual() + obtenerFechaActual() ));

    }
}
