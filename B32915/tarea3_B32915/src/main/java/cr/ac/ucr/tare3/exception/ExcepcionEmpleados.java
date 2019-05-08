package cr.ac.ucr.tare3.exception;


public class ExcepcionEmpleados extends Exception{

	
	/*Capturar las excepciones es indispensable y que se capturen
		 * en casos validos permite determinar cuales son los errores
		 * por los cuales se disparan. Las clases NullPointer o las relacionadas
		 * a File tienen casos que suelen darse y debido a esto arrojan la excepcion. Para esto crear una 
		 * clase de Excepciones para Empleados es buena practiva
		 * (Definir Clases de excepciones en base a las necesidades de los llamados pag 107)*/
	
	public ExcepcionEmpleados(String msg) {
		
		super(msg);
		
	}

}
