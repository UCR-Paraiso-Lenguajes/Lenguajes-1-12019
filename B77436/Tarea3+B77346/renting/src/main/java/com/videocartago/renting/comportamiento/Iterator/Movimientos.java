package com.videocartago.renting.comportamiento.Iterator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
public class Movimientos implements Agregado
{
	private Date date;
    public Vector<String> lista = new Vector<String>();
    
    public Movimientos() {}
    
    public Movimientos(List<String> list) {
    	if(list.size()==0) throw new RuntimeException("Los campos vienen vacíos");
    	for(int i=0;i<list.size();i++)
    		llenarLista(list.get(i));
    }
    
    @Override
     public Iterador getIterador()
    {
        return new IteradorConcreto(this);
    }
    
    public String calcularFecha() {
    	date= new Date();
    	DateFormat hourFormat = new SimpleDateFormat("dd/MM/yyyy");
    	return "Fecha: " +hourFormat.format(date);
    	
    }
    
    public String calcularHora() {
    	date = new Date();
    	DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
    	return "Hora: " +hourFormat.format(date);
    	
    }
    
    public void llenarLista(String tipoEstadoPelicula){
    	lista.add( new String( tipoEstadoPelicula +" "+ calcularHora() + calcularFecha()));
    	
    }
}
