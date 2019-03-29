package cr.ac.ucr.ie.tarea3lenguajes.domain;

/**
 *
 * @author Samuel
 */                             //Cap 6 Data Transfer Objects - DTOs
public class TransaccionDTO {   //Una clase que actua como intermediaria entre otras clases, en este caso persona y cliente
    private int id_persona;     //se podría decir que es algún tipo de intermediaria entre ambas
    private char genero;
    private int cuenta;

    public TransaccionDTO(int id,char genero,int cuenta) throws Exception {
        if(id <= 0 ) throw new Exception("El id no puede ser 0 o negativo");
        if(genero == ' ') throw new Exception("El género está vacio");
        if(cuenta <= 0)throw new Exception("El id no puede ser 0 o negativo");
        this.id_persona = id;
        this.genero = genero;
        this.cuenta = cuenta;
    }
    
    public int getId_persona() {
        return id_persona;
    }
    public char getGenero() {
        return genero;
    }
    public int getCuenta() {
        return cuenta;
    }

    
}
