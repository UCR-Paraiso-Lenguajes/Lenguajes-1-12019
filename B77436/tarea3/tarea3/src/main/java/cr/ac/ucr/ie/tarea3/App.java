package cr.ac.ucr.ie.tarea3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import cr.ac.ucr.ie.tarea3.domain.AritmeticaDatosObjetos;
import cr.ac.ucr.ie.tarea3.domain.Auto;
import cr.ac.ucr.ie.tarea3.domain.MensajeExcepción;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    }
    
   
    /*Capitulo 7
    * Tip 2
    * Escribir nuestro try-catch-finally primero
    * Aqui se ejemplifica como crear un metodo con try-catch para que cuando 
    * ocurran errores, no falle el programa
    * */
    public void iniciarApp() throws MensajeExcepción{
        AritmeticaDatosObjetos aritmetica = new AritmeticaDatosObjetos(0, 0);
        aritmetica.sumar();
	}
    	

    
}
