package cr.ac.ucr.ie.transferencia;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import cr.ac.ucr.ie.domain.Libro;

/*Cap 6 - Tip 4
 * Objectos de Transferencia de Datos  (OTD)
 * Estructura de datos, es una clase con variables públicas y sin funciones.
 * Importante para bases de datos y analizar mensajes de conexión.
 */
/*Se recomienda evitar clases hibridas que muestren una convinacion de objetos 
 * y estructuras de datos teniendo variables publicas y privadas*/

public class Tranferencia implements Transfiere {
	
	public int saldoActual;
	public int intereses;
	public String mensaje;
	public Libro libro;
	public Logger mesajeLog = Logger.getLogger(" ");
	public ArrayList<Libro> libros = new ArrayList<Libro>();

	@Override
	public void cancelar() {
		/*Cap 6- Tip 2
		 * Evitar choque de trenes
		 * segun la ley de demeter es necesario evitar los choques de trenes dividiendo
		 *  la operacion en partes*/
		String valorIntereses = String.valueOf(intereses);
		String mesajeSaldoActual = "Su valor actual es: "+saldoActual;
		String concatMensaje = mesajeSaldoActual.concat(valorIntereses);
		mensaje = concatMensaje;
		mesajeLog.log(Level.CONFIG, null,mensaje);
	}

	@Override
	public int saldo() {
		return 0;
	}

	@Override
	public int intereses() {
		return 0;
	}

	/* Cap 7 - Tip 7
	 * No delvolver NULL
	 *La idea es evitar execpciones de Null pointer exception con el fin de facilitar el codido
	 *y que sea mejor en manejo de errores
	 */
	@Override
	public Libro prestamo(Libro libro) {
		
		/* Cap 7 - Tip 2
		 * Crear primero la instrucción de try-catch finally.
		 */
		
		try { 
			for (int indexSize = 0; indexSize < libros.size(); indexSize++) {
				  if (libros.get(indexSize) == libro) 
				  return libros.get(indexSize);
			}// fin del for 
				
		}catch(Exception e) {
			/*CAp 7- Tip 4
			* Ofrecer contexto junto con las excepciones
	    	* si se tiene un registro para guardar los problemas, es mejor tener una buena 
	    	* descripcion de tales
	    	*/
		 	throw new RuntimeException("Problemas para prestar libro");
		} finally { 
			mesajeLog.log(Level.INFO,"Finalizo la solicitud del servicio");  
		}
		
		
		
		libro = new Libro();
		return libro;
	}

}
