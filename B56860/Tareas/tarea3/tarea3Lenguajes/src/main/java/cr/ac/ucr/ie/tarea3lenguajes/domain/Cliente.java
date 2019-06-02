package cr.ac.ucr.ie.tarea3lenguajes.domain;

/**
 *
 * @author Samuel
 */
public class Cliente {
    private int id;
    private final int CUENTA;

    public Cliente(int id) throws Exception {
        if(id <= 0 ) throw new Exception("El id no puede ser 0 o negativo");
        this.id = id;
        this.CUENTA = hashCode();
    }    
    
}
