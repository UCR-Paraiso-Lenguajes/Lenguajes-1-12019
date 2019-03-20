package cr.ac.ucr.ie.gui;

import java.awt.Label;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import cr.ac.ucr.ie.data.Registry;
import cr.ac.ucr.ie.domain.Car;

/* Capitulo 2 - Tip 4
 * Usar distinciones relevantes en 
 * el nombre. Añadir series de números 
 * a un mismo nombre o añadir una letra 
 * diferente, a pesar de, que hace un 
 * nombre de variable diferente, no añade 
 * ningún sentido al código.
 */

public class Menu {

	/* Capitulo 2 - Tip 5
	 * Nombres sencillos de encontrar. 
	 * La utilización de nombres con 
	 * solo una letra o con números son 
	 * complicados de encontrar. Es mejor 
	 * utilizar nombres completos.
	 */
	
	
	public Scanner dataEntry;
	
	Car car;//Objeto
	
	Registry registryCar = new Registry();
	
	short idCarEntry;
	
	String brandCarEntry, styleCarEntry, license_plateCarEntry; 
	
	Logger exitPrint = Logger.getLogger("Control");
	
	
	
	/* Capitulo 3 - Tip 4
	 * Que las funciones o métodos hagan 
	 * una cosa y que funcione. Si tiene 
	 * secciones esto quiere decir que 
	 * realiza mas de una cosa, además, 
	 * si este tiene mas de un nivel de 
	 * abstracción es otro indicador.
	 */
	
	public void ShowMenu () throws Exception{
		
		dataEntry = new Scanner(System.in);
		
		exitPrint.log(Level.INFO,"Welcome to the system."
				+ "\nEnter a number to select the desired option."
				+ "\n\n1) Add information about the car."
				+ "\n2) Modify information about the car."
				+ "\n3) Search information about the car."
				+ "\n4) Show information about the car."
				+ "\n5) Delete information about the car."
				+ "\n6) Exit");
		
		int numberSelected = dataEntry.nextInt();
		
		
		/* Capitulo 3 - Tip 5
		 * Que los efectos secundarios 
		 * en un método o función no existan, 
		 * ya que, se supone que solo tiene 
		 * que hacer una cosa y esta debe ser 
		 * funcional.
		 */
		while (numberSelected>0 && numberSelected<6) {
			
			if (numberSelected==1) {
				
				exitPrint.log(Level.INFO,"Add information about the car.\n");
				exitPrint.log(Level.INFO,"Insert id of the Car.\n");
				idCarEntry = dataEntry.nextShort();
				
				exitPrint.log(Level.INFO,"Insert brand of the Car.\n");
				brandCarEntry = dataEntry.next();
				
				exitPrint.log(Level.INFO,"Insert style of the Car.\n");
				styleCarEntry = dataEntry.next();
				
				exitPrint.log(Level.INFO,"Insert license plate of the Car.\n");
				license_plateCarEntry = dataEntry.next();
				
				car = new Car(idCarEntry, brandCarEntry, styleCarEntry, license_plateCarEntry);
				
				registryCar.addCar(car);
				
			}else if (numberSelected==2) {
				
				exitPrint.log(Level.INFO,"Modify information about the car.\n");
				exitPrint.log(Level.INFO,"Insert id of the Car.\n");
				idCarEntry = dataEntry.nextShort();
				
				exitPrint.log(Level.INFO,registryCar.searchCar(idCarEntry));
				
				exitPrint.log(Level.INFO,"Insert brand of the Car.\n");
				brandCarEntry = dataEntry.next();
				
				exitPrint.log(Level.INFO,"Insert style of the Car.\n");
				styleCarEntry = dataEntry.next();
				
				exitPrint.log(Level.INFO,"Insert license plate of the Car.\n");
				license_plateCarEntry = dataEntry.next();
				
				car = new Car(idCarEntry, brandCarEntry, styleCarEntry, license_plateCarEntry);
				
				registryCar.modifyCar(car);
				
			}else if (numberSelected==3) {
				
				exitPrint.log(Level.INFO,"Search information about the car.\n");
				exitPrint.log(Level.INFO,"Insert id of the Car.\n");
				
				idCarEntry = dataEntry.nextShort();
				
				exitPrint.log(Level.INFO,registryCar.searchCar(idCarEntry));
				
			}else if (numberSelected==4) {
				
				exitPrint.log(Level.INFO,"Show information about the car.\n");
				exitPrint.log(Level.INFO,registryCar.showCarList());
				
			}else if (numberSelected==5) {
				
				exitPrint.log(Level.INFO,"Delete information about the car.\n");
				exitPrint.log(Level.INFO,"Insert id of the Car.\n");
				
				idCarEntry = dataEntry.nextShort();
				
				exitPrint.log(Level.INFO,registryCar.searchCar(idCarEntry));
				
				registryCar.deleteCar(idCarEntry);
				
			}
			
			
			exitPrint.log(Level.INFO,"\n\nEnter a number to select the desired option."
					+ "\n\n1) Add information about the car."
					+ "\n2) Modify information about the car."
					+ "\n3) Search information about the car."
					+ "\n4) Show information about the car."
					+ "\n5) Delete information about the car."
					+ "\n6) Exit");
			
			numberSelected = dataEntry.nextInt();
			
		}
		
	}
}
