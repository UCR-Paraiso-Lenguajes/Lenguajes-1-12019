package cr.ac.ucr.examen.domain;


public class Curso {
	private String nombre;
	private String siglas;
	private int creditos;
	
	
	public Curso(String nombre, String siglas, int creditos) {
		setNombre(nombre);
		setSiglas(siglas);
		setCreditos(creditos);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre.trim().equalsIgnoreCase("") || nombre == null) throw new RuntimeException("El nombre no puede ser vacio");
		this.nombre = nombre;
	}
	public String getSiglas() {
		return siglas;
	}
	public void setSiglas(String siglas) {
		if(siglas.trim().equalsIgnoreCase("") || siglas == null) throw new RuntimeException("Las siglas no pueden ser vacias");
		this.siglas = siglas;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		if(creditos < 0) throw new RuntimeException("Los créditos deben ser mayores a 0");
		this.creditos = creditos;
	}
	
	
}