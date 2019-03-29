package ejemplos;

/**
 * Clase utilizada para subtema "Abstraccion de los datos" del capitulo 6
 * @author Jean Carlos Monge Mendez
 *
 */
public interface Triangulo {
	
	/*
	 * Los metodos no tienen la necesidad de mostrar cuanto miden los 
	 * lados, ni la altura del trianglo, estos datos se mantiene privados, sin la 
	 * posiblidad de accederlos fuera de la clase.
	 */

	public double ObtenerArea();
	public double ObtenerPerimetro();
}
