package Domain;

import java.util.List;

public class Curso {

	private String sigla;
	private String nombre;
	private int creditos;
	private boolean bloqueInicial;
	private boolean bloqueFinal;
	private List<Curso> cursosRequisito;
	
	public Curso() {
		super();
	}
	public Curso(String sigla, String nombre, int creditos, boolean bloqueInicial, boolean bloqueFinal,
			List<Curso> cursosRequisito) {
		super();
		this.sigla = sigla;
		this.nombre = nombre;
		this.creditos = creditos;
		this.bloqueInicial = bloqueInicial;
		this.bloqueFinal = bloqueFinal;
		this.cursosRequisito = cursosRequisito;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	
	public List<Curso> getCursosRequisito() {
		return cursosRequisito;
	}
	public void setCursosRequisito(List<Curso> cursosRequisito) {
		this.cursosRequisito = cursosRequisito;
	}
	public boolean isBloqueInicial() {
		return bloqueInicial;
	}
	public void setBloqueInicial(boolean bloqueInicial) {
		this.bloqueInicial = bloqueInicial;
	}
	public boolean isBloqueFinal() {
		return bloqueFinal;
	}
	public void setBloqueFinal(boolean bloqueFinal) {
		this.bloqueFinal = bloqueFinal;
	}

	
	
}
