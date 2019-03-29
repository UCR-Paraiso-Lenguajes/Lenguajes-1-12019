package cr.ac.ucr.ie.tarea3.domain;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;

import java.util.logging.Logger;

/*Tip 2:
 * Abstración de objectos y datos. Basado en la pagina 95. Es donde se implementa
 * la clase abstrato
 * */

public class AritmeticaDatosObjetos implements DatosObjetos { //Capitulo 7
															//Tip 6
															//Definir el flujo normal Basado en pag 109
															//Aqui podemos ejemplicar como podemos encapsular los metodos DatosObjetos
															// por lo tanto no lidiamos con un comportamiento excepcional

	private FileOutputStream fos = null;
    private ObjectOutputStream write = null;
	private double solicitaNumero1;
	private double solicitaNumero2;
	private double resultadoOperacion;
	
	
	public AritmeticaDatosObjetos(double solicitaNumero1, double solicitaNumero2)throws MensajeExcepción {
		/*Capitulo 7. Tip 1
		 * Usa excepciones en lugar de retornar codigos de error.
		 * Se utiliza una excepcion en lugar de retornar un mensaje de error
		 * */
		if(solicitaNumero1 == 0 && solicitaNumero2==0) throw new MensajeExcepción("Los datos vienen vaciós") ;
		
		this.solicitaNumero1=solicitaNumero1;
		this.solicitaNumero2=solicitaNumero2;
	}

	public int sumar()  {
		resultadoOperacion=0;
		resultadoOperacion=solicitaNumero1+solicitaNumero2;
		if(resultadoOperacion==0)
			return (int)resultadoOperacion;
		else {
			return 0;//Capitulo 2
					//Tip 7
					//No retorna nulos. Aqui se ejemplifica que cuando se realiza una operacion, y no lo realiza no va a poder retornar un valor nulo
		}
	}

	public void restar() {
		resultadoOperacion=0;
		resultadoOperacion=solicitaNumero1-solicitaNumero2;
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, "La resta de los numeros es: "+resultadoOperacion);
	}

	public void multiplicar() {
		resultadoOperacion=0;
		resultadoOperacion=solicitaNumero1*solicitaNumero2;
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, "La multiplicación de los numeros es: "+resultadoOperacion);
	}

	public void dividir() {
		resultadoOperacion=0;
		resultadoOperacion=solicitaNumero1/solicitaNumero2;
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, "La división de los numeros es: "+resultadoOperacion);
	}
	
	
	/*Capitulo 7
	    * Tip 2
	    * Escribir nuestro try-catch-finally primero
	    * Aqui se ejemplifica como crear un metodo con try-catch para que cuando 
	    * ocurran errores, no falle el programa
	    * */
	public void insertarAuto(Auto auto){
        try {
            fos = new FileOutputStream("./insertarAuto.dat", true);
            write = new ObjectOutputStream(fos);
            write.writeObject(auto);
            
        } catch (FileNotFoundException fnte) {
        }catch(IOException ioe){
        }finally {
            try {
                if(fos!=null) fos.close();
                if(write!=null) write.close();
            } catch (IOException e) {
            	Logger.getLogger(getClass().getName()).log(
        	            Level.INFO, e.getMessage());
            }
        }
    }//
	
	
}
