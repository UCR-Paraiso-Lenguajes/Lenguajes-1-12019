package cr.ac.ucr.ie.tarea3.interfaces;

import cr.ac.ucr.ie.tarea3.dominio.ListaExcepcion;
/*##### En esta clase se ejemplifica el tip #1 del Capitulo 6 "Abstraccion de datos" #######*/
import cr.ac.ucr.ie.tarea3.dominio.Nodo; 

public interface Lista {
    
    public int obtenerTamano() throws ListaExcepcion; // Devuelve el numero de elementos en la lista
	public boolean estaVacia(); // true si la lista esta vacia
	public Object obtenerUltimo()throws ListaExcepcion; //Devuelve el ultimo elemento de la lista
	
}
