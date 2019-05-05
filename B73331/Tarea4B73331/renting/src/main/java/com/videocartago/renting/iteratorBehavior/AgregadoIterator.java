package com.videocartago.renting.iteratorBehavior;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
public class AgregadoIterator implements Agregado
{
     protected Vector aDatos = new Vector();
    // -------------------------
    public AgregadoIterator() {
    }
    // -------------------------
    @Override
     public Movimientos getIterador()
    {
        return new IteradorMov( this );
    }
    // -------------------------
    
    private String obtenerFechaActual() {
    	Date date = new Date();
    	
    	DateFormat hourFormat = new SimpleDateFormat("dd/MM/yyyy");
    	return " Fecha: " +hourFormat.format(date);
    	
    }
    
    private String obtenerHoraActual() {
    	Date date = new Date();
    	
    	DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
    	return " Hora: " +hourFormat.format(date);
    	
    }
    
    public void agregar(String Tipo, String Pelicula)
    {
    	
        this.aDatos.add( new String( Tipo + ';'
        		+ Pelicula + ';' + obtenerHoraActual() + ';' + obtenerFechaActual() ));

    }
}
