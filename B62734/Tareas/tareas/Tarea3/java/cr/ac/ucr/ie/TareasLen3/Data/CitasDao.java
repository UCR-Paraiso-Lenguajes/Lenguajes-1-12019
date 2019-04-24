package cr.ac.ucr.ie.TareasLen3.Data;

import java.sql.Date;
import java.util.LinkedList;

import cr.ac.ucr.ie.TareasLen3.domain.Cita;
import cr.ac.ucr.ie.TareasLen3.domain.CitaException;
import cr.ac.ucr.ie.TareasLen3.domain.Medico;

public class CitasDao {
	//Cap 6: 4.Objetos de transferencia de datos:

	private LinkedList<Cita> citas;

	public CitasDao() {
		super();
		citas=new LinkedList<Cita>();
	}
	//Cap 6:Antisimetría de datos y objetos

	public void agregarCita(Medico medico, Date fecha) throws CitaException {
		//Cap 7: 7.No devolver null
		//Cap 7: 8.No pasar null
		try {
		if (medico!=null && fecha!=null) {
			Cita cita=new Cita(medico, fecha);
			if (!buscaFecha(cita)) {
				citas.add(cita);
			}else {
				throw new CitaException("Ese medico ya tiene una cita en esa fecha");
			}
		}else {
			throw new RuntimeException("Error nulos");
		}
		}catch(RuntimeException e){
			throw new CitaException("Se necesita un Medico y una fecha para sacar una cita");
		}
		//Cap 7: 2.Crear primero la instrucciòn try-catch-finally
		//Cap 7: 5.Definir clases de excepción de acuerdo a las necesidades el invocador
		//Cap 7: 6.Definir el flujo normal

	}
	public boolean buscaFecha(Cita cita) {
		boolean fechaOcupada=false;
		if (citas.contains(cita)) {
			fechaOcupada=true;
		}
		return fechaOcupada;
	}
}
