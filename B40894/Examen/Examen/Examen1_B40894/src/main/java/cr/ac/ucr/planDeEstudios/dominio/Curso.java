package cr.ac.ucr.planDeEstudios.dominio;


public class Curso {

	private String nombre;
	private String siglas;
	private int creditos;
	private Requisito requisito;
	private boolean iniciaFinal;
	
	
	
	public Curso(String nombre, String siglas, int creditos, Requisito requisito,boolean inicioFinal) {
        this.nombre = nombre;
		this.siglas = siglas;
		this.creditos = creditos;
		this.requisito = requisito;
		this.iniciaFinal=inicioFinal;
	}
	
	public Curso(String nombre, String siglas, int creditos,boolean inicioFinal) {
		super();
		this.nombre = nombre;
		this.siglas = siglas;
		this.creditos = creditos;
		this.iniciaFinal=inicioFinal;
	}
	
	public Curso() {
		super();
	}


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
	public Requisito getRequisito() {
		return requisito;
	}
	public void setRequisito(Requisito requisito) {
		this.requisito = requisito;
	}


	public boolean getIniciaFinal() {
		return iniciaFinal;
	}


	public void setIniciaFinal(boolean iniciaFinal) {
		this.iniciaFinal = iniciaFinal;
	}


 

	
	
	
}
