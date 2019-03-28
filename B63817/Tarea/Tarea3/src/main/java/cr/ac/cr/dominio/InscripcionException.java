package cr.ac.cr.dominio;

//Cap 7- caso5: Definir clases de excepciòn de acuerdo a las necesidades del invocador

public class InscripcionException extends Exception{

	public InscripcionException(String err) {
		super(err);
	}
}
