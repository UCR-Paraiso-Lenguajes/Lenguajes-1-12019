package cr.ac.ucr.innovacion.planestudios.domain;

public class Carrera {

	private String nombre;
	private PlanEstudios planEstudios;
	
	public Carrera(String nombre, PlanEstudios planEstudios) {
		super();
		this.nombre = nombre;
		this.planEstudios = planEstudios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public PlanEstudios getPlanEstudios() {
		return planEstudios;
	}

	public void setPlanEstudios(PlanEstudios planEstudios) {
		this.planEstudios = planEstudios;
	}
	
	
	
	
}
