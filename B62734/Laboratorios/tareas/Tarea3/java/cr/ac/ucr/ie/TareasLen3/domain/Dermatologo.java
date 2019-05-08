package cr.ac.ucr.ie.TareasLen3.domain;

public class Dermatologo extends Medico {
	private boolean contratado;

	public Dermatologo(String nombre, String cedula, String numeroTelefono, boolean disponibilidad) {
		super(nombre, cedula, numeroTelefono, disponibilidad);
		//cap 6: 1.Abstracción de datos		
		if (nombre!=null && cedula!=null && numeroTelefono!=null ) {
			contratado=true;		
		}else {
			throw new RuntimeException("El Dermatologo necesita datos");
		}
		
	}

	public boolean isContratado() {
		return contratado;
	}

	public void setContratado(boolean contratado) {
		this.contratado = contratado;
	}

}
