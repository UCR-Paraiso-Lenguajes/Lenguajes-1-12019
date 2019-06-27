package ucr.ac.cr.dominio;

public class Carrera {

	private PlanEstudios planEstudios;
	private String nombre;

	public Carrera(PlanEstudios planEstudios, String nombre) {
		super();
		if(nombre== null || nombre.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		this.planEstudios = planEstudios;
		this.nombre = nombre;
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
