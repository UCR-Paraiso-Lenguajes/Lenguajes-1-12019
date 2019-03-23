package cr.ac.ucr.ie.domain;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*Tips del capítulo 1*/

/*1. Basado en: pág 25 "Los nombres de las clases deben ser palabras con sustantivos o 
frases que contengan sustantivos." El nombre de las clases no pueden tener verbos. Leído
de Clean Code */
/*incorrecto
 * public class crearMenu()*/
//correcto
public class Menu {
	
	private Scanner readVariables = new Scanner(System.in);
	private ProblemsToResolve chooseProblem = new ProblemsToResolve();
	
	/*2. Basado en:  "El nombre de los métodos o funciones deben ser verbos" o frases con verbos,y debe poseer
	 * un nombre que explique que es lo que realiza. Leído
de Clean Code pág 25*/
	/*incorrecto
	 * public void choosenAction*/
	//correcto
	public void chooseAction() throws Exception{
		/*3.Basado en: Paginas 21 y 22 "Nombres pronunciables". Es importante usar nombres pronunciables acorde a su naturaleza
		 * de la creación, es decir con solo el nombre se debe entender lo que hace
		 * */
			//int choose=0; incorrecto
			//correcto
		int optionToChooseInMenu=0;
		do {
			Logger.getLogger(getClass().getName()).log(
					Level.INFO, "1. Calcular factorial\n"+
					"2. Calcular cantidad de dígitos de un numero\n"+
					"3. Ordenar un arreglo de numeros\n"+
					"-1. Salir");
			optionToChooseInMenu = readVariables.nextInt();
			if(optionToChooseInMenu==1) {
				Logger.getLogger(getClass().getName()).log(
						Level.INFO, "Ingrese el número para calcular el factorial");
					
				int insertNumber = readVariables.nextInt();
				chooseProblem.getFactorial(insertNumber);
					
					
			}else if(optionToChooseInMenu==2) {
				Logger.getLogger(getClass().getName()).log(
						Level.INFO, "Ingrese el número");
					
				double number = readVariables.nextDouble();
				chooseProblem.countNumberDigits(number);
					
					
			}else if(optionToChooseInMenu==3) {
				Logger.getLogger(getClass().getName()).log(
						Level.INFO, "Ingrese el tamaño del arreglo");
				int sizeofArray = readVariables.nextInt();
				int numbers[] = new int[sizeofArray];
				for(int i=0;i<numbers.length;i++) {
					Logger.getLogger(getClass().getName()).log(
							Level.INFO, "Ingrese un numero");
					numbers[i]= readVariables.nextInt();
				}
				chooseProblem.orderNumbersofArray(numbers);
			}else{
				Logger.getLogger(getClass().getName()).log(
							Level.INFO, "Error al introducir dato");
				throw new Exception("Ocurrió un falló");
				
			}
				
		}while(optionToChooseInMenu!=-1);
			
		
		
	}
}
