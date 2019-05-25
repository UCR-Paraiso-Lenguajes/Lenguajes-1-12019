package cr.ac.cr.dominio;

public class Circulo implements Figura {
	
	// Cap 6-caso 2: Antisimetrìa de datos y objetos 

	private double diametro;
	private double radio;
	public final double PI=3.1415;
	
	public Circulo(double diametro, double radio) {
		super();
		if(diametro == 0 ) throw new RuntimeException("El diametro debe ser mayor a 0");
		if(radio == 0 ) throw new RuntimeException("El radio debe ser mayor a 0");
		this.diametro = diametro;
		this.radio = radio;
	}
	@Override
	public double area() {
		
		return PI*(radio*radio);
	}
	@Override
	public double perimetro() {
		
		return PI*diametro;
	}
	
	public double getDiametro() {
		return diametro;
	}
	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	
	
	
	
}
