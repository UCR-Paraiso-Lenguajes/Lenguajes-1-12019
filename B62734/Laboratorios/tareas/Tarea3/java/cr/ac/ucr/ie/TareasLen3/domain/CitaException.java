package cr.ac.ucr.ie.TareasLen3.domain;

public class CitaException extends Exception {
	private String mensaje="";

	public CitaException(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return mensaje ;
	}
	
}
