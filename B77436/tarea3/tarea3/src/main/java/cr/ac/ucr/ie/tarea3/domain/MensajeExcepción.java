package cr.ac.ucr.ie.tarea3.domain;

public class MensajeExcepción extends Exception {
	/*Capitulo 7
	 * Tip 3
	 * Uso de excepciones sin comprobar. Es decir se crea una clase de excepcion
	 * y retorna un error cuando se ocupe
	 * */
	/*Capitulo 7
	 * Tip 5
	 * Definir clases de excepcion en terminos de necesidad
	 * Aqui podemos ejemplificar como creamos una clase para errores, y donde se puede
	 * llamar desde cualquier parte*/
	public MensajeExcepción(String mensaje) {
		super(mensaje);
	}
}
