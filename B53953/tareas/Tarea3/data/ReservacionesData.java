package data;

import java.util.LinkedList;

import domain.Cliente;
import domain.Reservacion;
import domain.Vuelo;

public class ReservacionesData {

	private LinkedList<Reservacion> reservaciones;



	public ReservacionesData() {
		super();
		reservaciones = new LinkedList<Reservacion>();
	}
	
	
	public void ingresarReservacion(Reservacion reservacion) {//cap 6:Anti-Simetría
		
		try {//cap 7:Escriba su declaración Try-Catch-Finally primero
			 //cap 7: Definir el flujo normal
		
			
			
		if(reservacion!=null) {//cap 7:No devuelvas nulo
		reservaciones.add(reservacion);
		
		
		}else {
			throw new RuntimeException("nulo");//cap 7:No pase nulo
		}
		
		} catch (Exception e) {
			throw new StorageException("retrieval error", e);//cap 7:Definir clases de excepción en términos de necesidades del llamante
			}
	
	
	
	
}

