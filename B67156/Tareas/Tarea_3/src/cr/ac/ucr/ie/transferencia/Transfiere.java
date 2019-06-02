package cr.ac.ucr.ie.transferencia;

import cr.ac.ucr.ie.domain.Libro;

public interface Transfiere {
	
	public void cancelar();
	
	public int saldo();
	
	public int intereses();
	
	public Libro prestamo(Libro libro);
	
}
