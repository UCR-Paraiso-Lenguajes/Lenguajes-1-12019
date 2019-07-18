package ucr.ac.cr.planDeEstudios.domain;

import java.util.ArrayList;
import java.util.List;

public class Ciclo {
	private int idArea;
	private int id;
	private String nombre;
	private ArrayList<Curso> cursos;
	public Ciclo(int idArea, int idCiclo, String nombre, ArrayList<Curso> cursos) {
		if(cursos==null||nombre==null||nombre.trim().equals("")||id<0||idArea<0)
			throw new RuntimeException("La lista viene vacia o el nombre viene vacio o el id es menor a cero o el idArea es menor a cero");
		this.idArea = idArea;
		this.id = idCiclo;
		this.nombre = nombre;
		this.cursos = cursos;
	}
	public Ciclo() {
	}
	public int getIdArea() {
		return idArea;
	}
	public void setIdArea(int idArea) {
		if(idArea<0)
			throw new RuntimeException("El idArea es menor a cero");
		this.idArea = idArea;
	}
	public int getIdCiclo() {
		return id;
	}
	public void setIdCiclo(int idCiclo) {
		if(id<0)
			throw new RuntimeException("El id es menor a cero");
		this.id = idCiclo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre==null||nombre.trim().equals(""))
			throw new RuntimeException("El nombre viene vacio");
		this.nombre = nombre;
	}
	public ArrayList<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(ArrayList<Curso> cursos) {
		if(cursos==null)
			throw new RuntimeException("La lista viene vacia");
		this.cursos = cursos;
	}
	
	
}
