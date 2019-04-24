package cr.ac.ucr.ie.tarea3lenguajes.domain;

/**
 *
 * @author Samuel
 */
public class Moto implements Vehiculo{
    
    private int cilindraje;
    private boolean avanzando;  
    
    @Override
    public String avanzar() {
        if(!this.avanzando){
            this.avanzando = true;                  
            return "La moto está avanzando..";
        }
        throw new UnsupportedOperationException("La moto ya estaba avanzando.");     //Cap7 Usar excepciones en vez de retornos 
    }                                                                                //Básicamente es evitar el uso de "Strings" de retornos       
                                                                                     //que en un futuro puede ser un error en capas superiores
    @Override                                                                        //la excepcion bota el programa, el retorno solo esconde el error.
    public String Detenerse() {
        if(!this.avanzando){
            this.avanzando = false;
            return "La moto ha frenado..";
        }
        throw new UnsupportedOperationException("La moto ya estaba detenido."); 
    }                                                                               //Cap 7 no retornar nulos
                                                                                    //no es una buena practica retornar nulos por lo que se retorna una excepcion
                                                                                    //en vez de retornar algun objeto que pueda ser nulo
    
}
