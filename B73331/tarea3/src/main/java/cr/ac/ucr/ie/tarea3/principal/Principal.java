package cr.ac.ucr.ie.tarea3.principal;

import java.io.ObjectInputStream.GetField;
import java.util.logging.Level;
import java.util.logging.Logger;

import cr.ac.ucr.ie.tarea3.dominio.ListaEnlazada;
import cr.ac.ucr.ie.tarea3.dominio.ListaExcepcion;

public class Principal {
	/*##### En esta clase se ejemplifica el tip #2 del Capitulo 7 "Escribir el enunciado try-catch-finnaly de primero" #######*/ 
	public void main(String[] args) {
		ListaEnlazada lista = new ListaEnlazada();
		try {
			lista.obtenerTamano();
		} catch (Exception e) {
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Excepcion, revisar el codigo");
		}finally {
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Gracias por usar la aplicacion");
		}
	}
}