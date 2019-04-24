package cr.ac.ucr.ie.TareasLen3.domain;

import java.sql.Date;

public class Cita {
	//Cap 6: 3.La ley de Demeter
  private Medico medico;
  private Date fecha;
public Cita(Medico medico, Date fecha) {
	super();
	if (medico!=null && fecha!=null) {
		this.medico = medico;
		this.fecha = fecha;	
	}else {
		throw new RuntimeException("Se necesita un Medico y una fecha para sacar una cita");
		//Cap 7: 1.Usar excepciones en lugar de códigos devueltos:
        //Cap 7: 3.Usar excepciones sin comprobar
		//Cap 7: 4.Ofrecer contexto junto a las excepciones
	}	
		
}
public Medico getMedico() {
	return medico;
}
public void setMedico(Medico medico) {
	if (medico!=null) {
		this.medico = medico;
	}
	else {
		throw new RuntimeException("Se necesita un Medico para sacar una cita");
	}
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
@Override
public String toString() {
	return "La cita es con el medico: " + medico.toString() + " en la fecha: " + fecha ;
}
  
  
}
