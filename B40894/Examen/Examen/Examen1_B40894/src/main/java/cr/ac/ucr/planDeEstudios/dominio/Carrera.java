package cr.ac.ucr.planDeEstudios.dominio;

public class Carrera {

	private String nombre;
	private PlanEstudios plan;
	
	
	
	
	/**
	 * @param nombre
	 * @param plan
	 */
	public Carrera() {
		super();

	}
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public PlanEstudios getPlan() {
		return plan;
	}
	public void setPlan(PlanEstudios plan) {
		this.plan = plan;
	}
	
	
	
}
