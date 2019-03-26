package ejemplos;

/**
 * Clase para controlar un tipo de excepcion para el capitulo 7
 * @author Jean Carlos Monge Mendez
 *
 */
public class ExcepcionNumerosInvalidos extends Exception{

	public ExcepcionNumerosInvalidos() {
		super("Los numeros deben tener un formato valido: valores > 0");
	}
}
