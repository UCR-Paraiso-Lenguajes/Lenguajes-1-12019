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
	
	
	public void ingresarReservacion(Reservacion reservacion) {//cap 6:Anti-Symmetry
		
		try {//cap 7:Write Your Try-Catch-Finally Statement First
			 //cap 7: Define the Normal Flow
		
			
			
		if(reservacion!=null) {//cap 7:Don’t Return Null
		reservaciones.add(reservacion);
		
		
		}else {
			throw new RuntimeException("nulo");//cap 7:Don’t Pass Null
		}
		
		} catch (Exception e) {
			throw new StorageException("retrieval error", e);//cap 7:Define Exception Classes in Terms of a Caller’s Needs
			}
	
	
	
	
}

