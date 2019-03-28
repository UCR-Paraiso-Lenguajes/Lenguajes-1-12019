package cr.ac.cr.dominio;

public class Circulo implements Figura {
	
	// Cap 6-caso 2: Antisimetrìa de datos y objetos 

	private double diametro;
	private double radio;
	public final double PI=3.1415;
	
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return 0;
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
