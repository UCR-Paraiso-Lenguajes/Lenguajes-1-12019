package cr.ac.ucr.ie.tarea3.domain;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LeyDemeter {
	/*Tip 3:
	 * Ley de dimeter. Basado en pagina 98
	 * Las variables deben tener claro las variables publicas y privadas*/
	private int numero1;
	private int numero2;
	
	public LeyDemeter(int numero1, int numero2) throws MensajeExcepción {
		/*Capitulo 7
		 * Tip 4
		 * Provee contexto con excepciones pag 107
		 * Aquí se ejemplifica cuando se provee una excepcion cuando un codigo fallá
		 * */
		if(numero1 == 0 && numero2==0) {//Capitulo 7 Tip 8. 
										//No pasar nulos. Basado en pag 111
										//Aqui se ejemlifica como comprobar que no pasen variables nulos
			throw new MensajeExcepción("Se encuentran datos sin valor");
		}
		this.numero1 = numero1;
		this.numero2 = numero2;
	}
	
	public void buscarNumeroMayor() throws MensajeExcepción {
		/*Aqui se implementa el choque de trenes de la ley dimeter
		 * */
		Utilidades util = new Utilidades();
		int sumadeNumeros = util.maximo(numero1, numero2);
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, "El numero mayor es: "+sumadeNumeros);
	}

}
