package cr.ac.ucr.ie.tarea3lenguajes.domain;

/**
 *
 * @author Samuel
 */
public class IdErroneo extends Exception {

    /**
     * Cap 7 Definir clases de excepción en terminos del llamado
     * Crear clases de excepción especificas en función de lo que se necesite 
     * para tener un mejor contexto y manejo de las mismas
     */
    public IdErroneo(String msg) {
        super(msg);
    }
}
