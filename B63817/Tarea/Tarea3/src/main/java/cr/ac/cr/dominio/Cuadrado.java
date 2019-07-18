package cr.ac.cr.dominio;

public class Cuadrado implements Figura {
	
	private double lado;

	public Cuadrado(double lado) {
		super();
		if(lado == 0 ) throw new RuntimeException("El lado debe ser mayor a 0");
		this.lado = lado;
	}

	@Override
	public double area() {
		
		return lado*lado;
	}

	@Override
	public double perimetro() {
	 
		return 4*lado;
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	
}
