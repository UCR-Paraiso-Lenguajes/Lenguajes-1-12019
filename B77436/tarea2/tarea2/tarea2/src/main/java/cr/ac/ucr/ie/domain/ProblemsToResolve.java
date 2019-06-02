package cr.ac.ucr.ie.domain;

import java.math.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*Tips del capítulo 1*/

/*4. Basado en: Pagina 10. "Evitar codificaciones" de clases, metodos, funciones; deben decir porque de la existencia,
 * que hacen y como se usan*/
//public class tretroMethods --incorrecto ya que otra persona al leer la clase no sabra de que trata
//correcto
public class ProblemsToResolve {
	/*5. Basado en: Pagina 27 y 28. "Añadir un contexto significativo", es decir un explicacion significativa de lo que va a 
	 * realizar el metodoo funciones, para que sea facil de entender*/
	//La funcion para recibir un numero y calcular el factorial de ese numero.........
	public  void getFactorial(int getNumber)  {
		/*Capitulo 2
		 * 6.Basado en: Pagina 36. "NO tener efectos secundarios", el codigo debe estar bien identado dentro de lso ciclos, metodos
		 * y funcion para su facilidad de leer, comprension y orden, y muy importante que debe
		 * realizar solo una accion, ejemplo si el codigo de obtener factorial, ocupara hacer una fila
		 * se debe hacer en otro metodo*/
		long countFactorial=1;
		for(int i=getNumber;i>0;i--) {
			countFactorial = countFactorial*i;
		}
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, "El numero factorial es: "+countFactorial);
	}
	
	/*Capitulo 2
	 * 7. Basado en: pagina 39. "usar nombres descriptivos", importante que el nombre de los metodos y funciones
	 * describan lo que hacen para que otros programadores en un futuro comprendan bien*/
	//public void count--incorrecto
	//correcto
	public void countNumberDigits(double numberInsert) {//obtiene el numero de digitos de un numero
		/*capitulo 2
		 * 8. Basado en: Pagina 36. "Secciones dentro de funciones": importante dentro de los metodos y funciones que primero se declaran
		 * variables, luego se inicializan, y por ultimo se realizan las operaciones*/
		double count_digits;//declaracion de varibles
		count_digits=0;//inicializacion
		count_digits = Math.ceil(Math.log10(numberInsert));//operaciones
		if(numberInsert==1)//
			count_digits=1;//
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, "El numero de digitos es:"+(int)count_digits+"\n");
	}
	
	
	/*capitulo 2
	 * 9. Nombres cortos:es mucho mas facil entender el codigo cuando es simple y corto, ya que es una de las reglas
	 * que deben tener un codigo*/
	//incorrecto
	/*
	 * public void arrayOfNumbersInsertedByUsers
	 * */
	//correcto ya que es nombrada con un verbo que explica que hace y no es tan extenso
	public void orderNumbersofArray(int listNumber[]/*lista de arreglos*/) {
		/*Capitulo 2
		 * 10. Basado en: pagina 36. "Nivel de abstracción por nivel": explicar la intencion 
		 * de la funcion, metodos, es decir tratar de hacer lo mas sencillo posible, y realizar
		 * una acción a la vez, por ejemplo el siguiente codigo ordena los numeros y al final se llama
		 * otro metodo para mostrarlos, algo incorrecto seria hacer las operaciones para mostrarlos
		 * en este mismo metodo
		 * */
		if(listNumber.length > 0) {
			for(int i = 0; i < listNumber.length - 1; i++)
	        {
	            for(int j = 0; j < listNumber.length - 1; j++)
	            {
	                if (listNumber[j] > listNumber[j + 1])
	                {
	                    int aux = listNumber[j+1];
	                    listNumber[j+1] = listNumber[j];
	                    listNumber[j] = aux;
	                }
	            }
	        }
			showListOfNumber(listNumber);
		}else {
			Logger.getLogger(getClass().getName()).log(
		            Level.INFO, "El arreglo se encuentra vació\n");
		}
		
        
	}
	
	public void showListOfNumber(int[] arrayOfNumbers) {
		if(arrayOfNumbers.length > 0) {
			for(int i = 0;i < arrayOfNumbers.length; i++)
	        {
	        	Logger.getLogger(getClass().getName()).log(
	    	            Level.INFO,arrayOfNumbers[i]+", ");
	        }
	        Logger.getLogger(getClass().getName()).log(
		            Level.INFO, "\n");
		}else {
			Logger.getLogger(getClass().getName()).log(
		            Level.INFO, "El arreglo se encuentra vació\n");
		}
		
	}


}
	
	


