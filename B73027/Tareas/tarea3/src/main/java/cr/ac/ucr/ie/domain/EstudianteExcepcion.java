package cr.ac.ucr.ie.domain;

/*Aqui se muestran las  excepciones sin comprobar*/
/* Se define una clase de excepcion segun las necesidades del invocador */
public class EstudianteExcepcion extends Exception {
	
	public EstudianteExcepcion (String mensajeError) {
		super(mensajeError);
	}

}
