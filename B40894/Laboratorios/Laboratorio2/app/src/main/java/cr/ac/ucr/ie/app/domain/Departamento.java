package cr.ac.ucr.ie.app.domain;

import java.util.List;

public class Departamento {
	
	private int codDepto;
	private String nombreDepartamento;
	
	public Departamento(int codDepto, String nombreDepartamento) {
		if(codDepto <=0) throw new RuntimeException("El id debe ser mayor a 0");
		if(nombreDepartamento == null || nombreDepartamento.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		
		this.codDepto= codDepto;
		this.nombreDepartamento = nombreDepartamento;
		
	}

	public int getCodDepto() {
		return codDepto;
	}

	public void setCodDepto(int codDepto) {
		this.codDepto = codDepto;
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}
	
	

}
