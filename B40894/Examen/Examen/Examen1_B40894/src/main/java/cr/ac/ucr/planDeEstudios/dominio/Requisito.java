package cr.ac.ucr.planDeEstudios.dominio;

public class Requisito {
	
	private String nombre;
	private String siglas;
	private int creditos;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSiglas() {
		return siglas;
	}
	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public Requisito(String nombre, String siglas, int creditos) {
		super();
		this.nombre = nombre;
		this.siglas = siglas;
		this.creditos = creditos;
	}
	
	public Requisito() {
		super();
	}

}
