/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.ie.tarea3lenguajes.domain;

/**
 *
 * @author Samuel
 */
public class Carro implements Vehiculo{
    
    private int puertas;
    private boolean avanzando;  
    
    @Override
    public String avanzar() {
        if(!this.avanzando){                        //Cap 6 La ley de Demeter (Principio de conocimiento mínimo)
            this.avanzando = true;                  //En este capítulo enffoca como deben actuar basicamente los objetos 
            return "El carro está avanzando..";     //y las funciones de una clase, en el sentido de qué es lo que puedo ver
        }                                           //en función de su delimitacion según en que clase o método esté.
        throw new UnsupportedOperationException("El carro ya estaba avanzando."); 
    }

    @Override
    public String Detenerse() {
        if(!this.avanzando){
            this.avanzando = false;
            return "El carro ha frenado..";
        }
        throw new UnsupportedOperationException("El carro ya estaba detenido."); //Cap 7 Usar Excepciones no chequeadas / proveer información junto a la excepcion
                                                                                 //en este caso el método inmediatamente después de ser invocada
                                                                                 //"bota" el pprograma, además por el texto informa la causa y el contexto
    }
    
}
