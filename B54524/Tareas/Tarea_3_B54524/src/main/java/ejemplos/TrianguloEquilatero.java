package ejemplos;

/**
 * Clase utilizada para subtema "Datos/Antisimetria de los objetos" del capitulo 6
 * Ejemplo de una clase de tipo "Orientacion a objetos"
 * y Control de Excepciones: No recibir objetos nulos
 * @author Jean Carlos Monge Mendez
 *
 */
public class TrianguloEquilatero implements Triangulo {
	
	/*
	 * No se expone los detalles de los datos, se muestran de forma abstracta / P.95
	 * 
	 * En estas clases si se agrega un nuevo metodo a la interfaz Triangulo, se deben modificar 
	 * todas las clases que han implementado Triangulo, en este caso se debera modificar no solo 
	 * la interfaz, tambien la clase TrianguloEquilatero y si hubiera otra clase llamada 
	 * TrianguloIsoceles o TrianguloEscaleno que implementen Triangulo se deberan modificar todas.
	 */
	
	private double base;
	private double altura;
	private double lado;
	
	/**
	 * Se valida que los parametros sean valores validos
	 * @param base
	 * @param altura
	 * @param lado
	 * @throws ExcepcionNumerosInvalidos 
	 */
	public TrianguloEquilatero(double base, double altura, double lado) throws ExcepcionNumerosInvalidos {
		if(base > 0 && altura > 0 && lado > 0) {
			this.base = base;
			this.altura = altura;
			this.lado = lado;
		}else {
			throw new ExcepcionNumerosInvalidos();
		}
	}
	
	@Override
	public double ObtenerArea() {
		return (base*altura)/2;
	}
	
	@Override
	public double ObtenerPerimetro() {
		return lado*3;
	}
}
