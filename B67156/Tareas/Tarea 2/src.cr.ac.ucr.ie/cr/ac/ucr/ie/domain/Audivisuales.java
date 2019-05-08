package cr.ac.ucr.ie.domain;

public class Audivisuales {

	/*Tip 2
	 * Nombres significativos para variables
	 *Las variables revelan su cometido,ya que son o la unidad de medida o una descripcion significativa
	 *no se utilizan prefijos puesto no cambiaria su significado
	 *Nombres cortos 
	 *No existen redundancias
	 *No existen abreviaciones o simplificaciones 
	 *ver Pag de 45 a 50*/
	public String nombreDeAudivisuales;
	public String codigo;
	
	public Audivisuales(String nombreDeAudivisuales, String codigo) {
		super();
		this.nombreDeAudivisuales = nombreDeAudivisuales;
		this.codigo = codigo;
	}
	
	/*Tip 3
	 * El siguiente bloque de métodos, su función es modificación y acceso, por tanto se utilizan los
	 * prefijos correspondientes: get para acceso, set para modificación
	 * ver Pag 53*/
	public String getNombreDeAudivisuales() {
		return nombreDeAudivisuales;
	}
	public void setNombreDeAudivisuales(String nombreDeAudivisuales) {
		this.nombreDeAudivisuales = nombreDeAudivisuales;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
