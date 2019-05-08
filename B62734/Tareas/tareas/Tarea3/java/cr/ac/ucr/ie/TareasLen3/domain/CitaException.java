package cr.ac.ucr.ie.TareasLen3.domain;

public class CitaException extends Exception {
	private String mensaje="";

	public CitaException(String mensaje) {
		super();
		if (mensaje!=null) {
			this.mensaje = mensaje;

		}else {
			throw new RuntimeException("La Exepcion necesita un mensaje");
		}
	}

	@Override
	public String toString() {
		return mensaje ;
	}
	
}
