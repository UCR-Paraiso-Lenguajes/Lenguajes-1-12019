package cr.ac.ucr.ie.tarea3lenguajes.domain;

/**
 *
 * @author Samuel
 */
interface Vehiculo {
    
    /*
    *
    Cap 6 Anti-simetría del objeto/dato
    
        En este apartado se explica el por que es diferente (virtualmente) un objeto de un dato
        Tiene que ver mas que todo con que un objeeto tiene la capacidad para abstraer información 
        y tener funciones o funcionaalidades que lo caractericen, en este ejemplo la interfaz Vehiculo
        y las clases carro y moto.
    *
    */
    
    public String avanzar();
    public String Detenerse();
}
