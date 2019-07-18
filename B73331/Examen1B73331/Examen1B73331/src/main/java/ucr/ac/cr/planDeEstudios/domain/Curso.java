package ucr.ac.cr.planDeEstudios.domain;

public class Curso {
	private int idCiclo;
	private int id;
	private String nombre;
	private boolean aprobado;
	private int creditos;
	private String siglas;
	public Curso(int idCiclo, int id, String nombre, int creditos, String siglas ) {
		if(nombre==null||nombre.trim().equals("")||id<0||idCiclo<0 ||creditos<0||siglas==null||siglas.trim().equals(""))
			throw new RuntimeException("El nombre viene vacio o el id es menor a cero o el idCiclo es menor a cero, o los creditos son menor a cero o las siglas esta vacia");
		this.idCiclo = idCiclo;
		this.id = id;
		this.nombre = nombre;
		this.creditos = creditos;
		this.siglas = siglas;
	}
	public Curso() {
	}
	
	public String getSiglas() {
		return siglas;
	}
	public void setSiglas(String siglas) {
		if(siglas==null||siglas.trim().equals("")) throw new RuntimeException("Las siglas esta vacia");
		this.siglas = siglas;
	}
	public boolean isAprobado() {
		return aprobado;
	}
	public void setAprobado(boolean aprobado) {
		this.aprobado = aprobado;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		if(creditos<0)
			throw new RuntimeException("Los creditos son menor a cero");
		this.creditos = creditos;
	}
	public int getIdCiclo() {
		return idCiclo;
	}
	public void setIdCiclo(int idCiclo) {
		if(idCiclo<0)
			throw new RuntimeException("El idCiclo es menor a cero");
		this.idCiclo = idCiclo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		if(id<0)
			throw new RuntimeException("El id es menor a cero");
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre==null||nombre.trim().equals(""))
			throw new RuntimeException("El nombre viene vacio");
		this.nombre = nombre;
	}
	
	
	
}
