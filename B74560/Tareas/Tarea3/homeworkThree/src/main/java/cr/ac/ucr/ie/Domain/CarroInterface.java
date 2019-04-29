package cr.ac.ucr.ie.Domain;

/*Capitulo 6 - Tip 1
 * Abstracción 
 * Un método se declara como abstracto porque en 
 * ese momento (en esa clase) no se conoce 
 * cómo va a ser su implementación.
 * Representar los datos de la mejor manera.
 */

/*Capitulo 6 - Tip 4
 * Objectos de Transferencia de Datos  (OTD)
 * Estructura de datos, es una clase con variables públicas y sin funciones.
 * Importante para bases de datos y analizar mensajes de conexión.
 */


public abstract interface CarroInterface {
	
	public void añadirCarro (Carro carro);
	public Carro buscarCarro (short id);
	public String mostrarListaCarro ();
	public void eliminarCarro (short id);
	public void modificarCarro (Carro carro);
	
}
