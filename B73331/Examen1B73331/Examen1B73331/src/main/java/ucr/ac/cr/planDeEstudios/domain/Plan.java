package ucr.ac.cr.planDeEstudios.domain;

import java.util.ArrayList;
import java.util.List;

public class Plan {
	private ArrayList<Area> areas;
	private String nombre;
	public Plan(String nombre) {
		
		this.areas = new ArrayList<>();
		
		
		ArrayList<Ciclo> ciclos = new ArrayList<>();
		ArrayList<Curso> cursos = new ArrayList<>();
		areas.add(new Area("ESTRATEGIA E INNOVACION", 0, ciclos));
		ciclos.add(new Ciclo(0, 0, "Ciclo V", cursos));
		cursos = new ArrayList<>();
		ciclos.add(new Ciclo(0, 1, "Ciclo VI", cursos));
		cursos = new ArrayList<>();
		ciclos.add(new Ciclo(0, 2, "Ciclo VII", cursos));
		cursos = new ArrayList<>();
		ciclos.add(new Ciclo(0, 3, "Ciclo VIII", cursos));
		cursos = new ArrayList<>();
		ciclos.add(new Ciclo(0, 4, "Ciclo IX", cursos));
		cursos = new ArrayList<>();
		ciclos.add(new Ciclo(0, 5, "Ciclo X", cursos));
		
		ciclos = new ArrayList<>();
		cursos = new ArrayList<>();
		areas.add(new Area("ANALISIS E INVESTIGACION", 1, ciclos));
		ciclos.add(new Ciclo(1, 0, "Ciclo V", cursos));
		cursos = new ArrayList<>();
		ciclos.add(new Ciclo(1, 1, "Ciclo VI", cursos));
		cursos = new ArrayList<>();
		ciclos.add(new Ciclo(1, 2, "Ciclo VII", cursos));
		cursos = new ArrayList<>();
		ciclos.add(new Ciclo(1, 3, "Ciclo VIII", cursos));
		cursos = new ArrayList<>();
		ciclos.add(new Ciclo(1, 4, "Ciclo IX", cursos));
		cursos = new ArrayList<>();
		ciclos.add(new Ciclo(1, 5, "Ciclo X", cursos));
		cursos = new ArrayList<>();
		
		ciclos = new ArrayList<>();
		areas.add(new Area("HABILIDADES GERENCIALES", 2, ciclos));
		cursos = new ArrayList<>();
		ciclos.add(new Ciclo(2, 0, "Ciclo V", cursos));
		cursos = new ArrayList<>();
		ciclos.add(new Ciclo(2, 1, "Ciclo VI", cursos));
		cursos = new ArrayList<>();
		ciclos.add(new Ciclo(2, 2, "Ciclo VII", cursos));
		cursos = new ArrayList<>();
		ciclos.add(new Ciclo(2, 3, "Ciclo VIII", cursos));
		cursos = new ArrayList<>();
		ciclos.add(new Ciclo(2, 4, "Ciclo IX", cursos));
		cursos = new ArrayList<>();
		ciclos.add(new Ciclo(2, 5, "Ciclo X", cursos));
		
		ciclos = new ArrayList<>();
		areas.add(new Area("ETICA Y SOSTENIBILIDAD", 3, ciclos));
		cursos = new ArrayList<>();
		ciclos.add(new Ciclo(3, 0, "Ciclo V", cursos));
		cursos = new ArrayList<>();
		ciclos.add(new Ciclo(3, 1, "Ciclo VI", cursos));
		cursos = new ArrayList<>();
		ciclos.add(new Ciclo(3, 2, "Ciclo VII", cursos));
		cursos = new ArrayList<>();
		ciclos.add(new Ciclo(3, 3, "Ciclo VIII", cursos));
		cursos = new ArrayList<>();
		ciclos.add(new Ciclo(3, 4, "Ciclo IX", cursos));
		cursos = new ArrayList<>();
		ciclos.add(new Ciclo(3, 5, "Ciclo X", cursos));
		
		this.nombre = nombre;
	}
	public Plan() {
	}
	public ArrayList<Area> getAreas() {
		return areas;
	}
	public void setAreas(ArrayList<Area> areas) {
		if(areas==null||nombre.trim()==null) throw new RuntimeException("La lista viene vacia");
		this.areas = areas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre==null||nombre.trim().equals("")) throw new RuntimeException("El nombre viene vacio");
		this.nombre = nombre;
	}
	
	
	
	
}
