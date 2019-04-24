package cr.ac.ucr.ie.Domain;

import cr.ac.ucr.ie.Exceptions.Excepciones;


/* Capirulo 6 - Tip 2 
 * Asimetría de datos y objectos
 * Estructura de datos: Facilita la inclusión de nuevas funciones.
 * Orientación a Objectos: Facilita la inclusión de nuevas clases pero es muy complicado la inclusión de funciones.
 */


public class Carro {
	
	/*Capitulo 6 - Tip 3
	 * Ley de Demeter
	 * Objectos privados que solo se comuniquen con los de su interés.
	 * Ocultar la Estructura
	 * Ocultar información y cumplir la ley de Demeter.
	 */
	
	private short idCarro = 0;
	private String marcaCarro = "";
	private String estiloCarro = "";
	private String numPlacaCarro="";
	
	public Carro() {}
	
	public Carro(short idCarro, String marcaCarro, String estiloCarro, String numPlacaCarro) {
		
		/* Capitulo 7 - Tip 1
		 * Usar excepciones en lugar de códigos devueltos
		 * Tener un código más limpio y que resuelva los 
		 * errores, son dos formas muy importantes, esto 
		 * hace que el código de vea separado de las 
		 * excepciones.
		 */
		
		/* Capitulo 7 - Tip 8
		 * No pasar NULL
		 * No pasar un null, ya que, puede 
		 * hacer una excepción en tiempo 
		 * de ejecución.
		 */
		if (marcaCarro==null || marcaCarro.trim().equals("")) 
			throw new Excepciones("The text field of the brand of the car is empty, fill correctly.");
		if (estiloCarro==null || estiloCarro.trim().equals("")) 
			throw new Excepciones("The text field of the style of the car is empty, fill correctly.");
		
		/* Capitulo 7 - Tip 5
		 * Definir clases de excepción de 
		 * acuerdo a las necesidades del
		 * invocador
		 * El poder invocar excepciones 
		 * que nos ayuden a capturar una 
		 * excepción. Envolver API externas 
		 * y bibliotecas.
		 */
		
		if (numPlacaCarro==null || numPlacaCarro.trim().equals("")) 
			throw new Excepciones("The text field of the License plate of the car is empty, fill correctly.");
		if (idCarro<=0 && idCarro>100) 
			throw new Excepciones("The text field of the License plate of the car is empty, fill correctly.");
			
		this.idCarro = idCarro;
		this.marcaCarro = marcaCarro;
		this.estiloCarro = estiloCarro;
		this.numPlacaCarro = numPlacaCarro;
		
	}
	
	public short getIdCarro() {
		return idCarro;
	}
	public void setIdCarro(short idCarro) {
		this.idCarro = idCarro;
	}
	public String getMarcaCarro() {
		return marcaCarro;
	}
	public void setMarcaCarro(String marcaCarro) {
		this.marcaCarro = marcaCarro;
	}
	public String getEstiloCarro() {
		return estiloCarro;
	}
	public void setEstiloCarro(String estiloCarro) {
		this.estiloCarro = estiloCarro;
	}
	public String getNumPlacaCarro() {
		return numPlacaCarro;
	}
	public void setNumPlacaCarro(String numPlacaCarro) {
		this.numPlacaCarro = numPlacaCarro;
	}
	
}
