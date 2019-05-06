package cr.ac.ucr.ie.Exceptions;


/* Capitulo 7 - Tip 3 
 * Las excepciones comprobadas pueden ser 
 * utiles si tiene que crear una biblioteca 
 * crítica: tendra que capturarlas. Pero en 
 * el desarrollo de alicaciones generales, 
 * los costes de dependencia superan las
 * ventajas.
 */


/* Capitulo 7 - Tip 6
 * Definir el flujo normal
 * Separar la lógica empresarial, 
 * de la lógica de excepciones.
 */
public class Excepciones extends RuntimeException{

	
	public Excepciones() {
		super();
	}
	
	/* Capitulo 7 - Tip 4 
	 * Ofrecer contexto junto a las excepciones
	 * Determinar el origen y  
	 * la ubicación de un error.
	 */
	
	public Excepciones(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public Excepciones(String message, Throwable cause) {
		super(message, cause);
	}

	public Excepciones(String message) {
		super(message);
	}

	public Excepciones(Throwable arg0) {
		super(arg0);
		// 
	}
	
}
