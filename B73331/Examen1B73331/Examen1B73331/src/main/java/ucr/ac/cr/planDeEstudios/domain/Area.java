package ucr.ac.cr.planDeEstudios.domain;

import java.util.ArrayList;
import java.util.List;

public class Area {
	private String nombre;
	private int id;
	private ArrayList<Ciclo> ciclos;
	public Area(String nombre, int id, ArrayList<Ciclo> ciclos) {
		if(ciclos==null||nombre==null||nombre.trim().equals("")||id<0) throw new RuntimeException("La lista viene vacia o el nombre viene vacio o el id es menor a cero");
		this.nombre = nombre;
		this.id = id;
		this.ciclos = ciclos;
	}
	public Area() {
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre==null||nombre.trim().equals("")) throw new RuntimeException("El nombre viene vacio");
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		if(id<0) throw new RuntimeException("El id es menor a cero");
		this.id = id;
	}
	public ArrayList<Ciclo> getCiclos() {
		return ciclos;
	}
	public void setCiclos(ArrayList<Ciclo> ciclos) {
		if(ciclos==null) throw new RuntimeException("La lista viene vacia");
		this.ciclos = ciclos;
	}
	
	
	
	
	
	
}
