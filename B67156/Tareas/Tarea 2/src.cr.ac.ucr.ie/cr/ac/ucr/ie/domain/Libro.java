package cr.ac.ucr.ie.domain;

public class Libro {

	/*Tip 2
	 * Nombres significativos para variables
	 *Las variables revelan su cometido,ya que son o la unidad de medida o una descripcion significativa
	 *no se utilizan prefijos puesto no cambiaria su significado
	 *Nombres cortos 
	 *No existen redundancias
	 *No existen abreviaciones o simplificaciones 
	 *ver Pag de 45 a 50*/
	
	public String nombreDeLibro;
	public String Editorial;
	public String Año;
	
	public Libro(String nombreDeLibro, String editorial, String año) {
		super();
		this.nombreDeLibro = nombreDeLibro;
		Editorial = editorial;
		Año = año;
	}
	
	/*Tip 3
	 * El siguiente bloque de métodos, su función es modificación y acceso, por tanto se utilizan los
	 * prefijos correspondientes: get para acceso, set para modificación
	 * ver Pag 53*/
	public String getNombreDeLibro() {
		return nombreDeLibro;
	}
	public void setNombreDeLibro(String nombreDeLibro) {
		this.nombreDeLibro = nombreDeLibro;
	}
	public String getEditorial() {
		return Editorial;
	}
	public void setEditorial(String editorial) {
		Editorial = editorial;
	}
	public String getAño() {
		return Año;
	}
	public void setAño(String año) {
		Año = año;
	}
	
}
