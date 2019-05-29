package Domain;

import java.util.List;

public class PlanEstudios {

	private String nombre;
	//private int cantidadCreditos;
	private List<Curso> cursosDelPlan;
	
	public PlanEstudios(String nombre, List<Curso> cursosDelPlan) {
		super();
		
		//TODO: VALIDAR
		this.nombre = nombre;
		this.cursosDelPlan = cursosDelPlan;
	}

	public PlanEstudios() {
		super();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Curso> getCursosDelPlan() {
		return cursosDelPlan;
	}
	public void setCursosDelPlan(List<Curso> cursosDelPlan) {
		this.cursosDelPlan = cursosDelPlan;
	}

	@Override
	public String toString() {
		return "PlanEstudios [nombre=" + nombre + ", cursosDelPlan=" + cursosDelPlan + "]";
	}
	
	
	
}
