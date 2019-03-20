package cr.ac.ucr.ie.data;

import java.util.ArrayList;
import java.util.logging.Logger;

import cr.ac.ucr.ie.domain.Car;

/* Capitulo 2 - Tip 2
 *Evitar que los nombre de las clases sean verbos. 
 *Se acostumbra utilizar sustantivos singulares 
 *para nombrar las clases.Y al contrario con los 
 *nombres de métodos, utilice verbos para nombrarlos.
 */

public class Registry {
	
	
	/* Capitulo 2 - Tip3
	 *Variables con nombre que cumplan 
	 *un sentido con su función en el 
	 *código, ya que esto va a facilitar 
	 *el entendimiento de éstas. Además, 
	 *es posible que usted esté trabajando 
	 *con otras personas que no sabrán que 
	 *significa ese nombre  o que función 
	 *cumple en el código si los nombres 
	 *están implícitos en el código.
	 */
	
	Logger exitPrint = Logger.getLogger("Control");
	ArrayList<Car> carList = new ArrayList<Car>();
	
	
	/* Capitulo 3 - Tip 1
	 * Espacio entre  instrucciones y endentar. 
	 * Esto hace que el código tenga buen 
	 * aspecto y además, sea mas entendible. 
	 */
	
	public void addCar (Car car) {
		
		carList.add(car);
		exitPrint.log(null,"Proceso exitoso");
		System.out.println("The car was successfully registered.");
		
	}// addCar
	
	
	/* Capitulo 3 - Tip 2
	 * Código reducido en longitud.  
	 * La longitud no tiene que ver 
	 * con la calidad del código, 
	 * pero, entre mas reducido es 
	 * mas eficiente el código, ya 
	 * que el código se hace más 
	 * entendible y además, el consumo 
	 * de memoria y recursos se reducen.
	 */
	
	
	public String searchCar (short id) {
		
		for (int i = 0; i < carList.size(); i++) {
			
		    if (carList.get(i).getIdCar() == id) return carList.get(i).toString(); // fin del if 
		    
		}// fin del for 
		
		return null;
	
	}// fin de searchCar
	
	
	/* Capitulo 3 - Tip 3
	 * Los parámetros son una forma de 
	 * intercambiar información con el 
	 * método, a pesar de que pueden servir 
	 * para introducir datos para ejecutar 
	 * el método, lo ideal es que no se usen 
	 * o sea lo menos posible. Como un máximo 
	 * de tres parámetros.
	 */
	
	public String showCarList () {
		
		String carListComplet = "";
		
		for (int indexSize = 0; indexSize < carList.size(); indexSize++) {
			
			carListComplet += carList.get(indexSize).toString() + '\n';
			
		}
		
		carListComplet+='\n';
		return carListComplet;
		
	}
	
	public void deleteCar (short id) {
		
		for (int i = 0; i < carList.size(); i++) {
			
		    if (carList.get(i).getIdCar() == id)  {
		    	
		    	carList.remove(i);
		    	System.out.println("The car with the requested id number: "+id+" was found and removed.\n"); 
		    	
		    }else System.out.println("The requested car was not found.\n");
		    
		}// fin del for 
	
	}// fin de deleteCar
	
	public void modifyCar (Car car) {
		
		short id = car.getIdCar();
		
		for (int i = 0; i < carList.size(); i++) {
			
		    if (carList.get(i).getIdCar() == id) {
		    	
		    	carList.remove(i); 
		    	System.out.println("The car with the requested id number: "+id+" was found and modified.\n"); 
		    	carList.add(car);
		    	
		    }else System.out.println("The requested car was not found.\n");
		    
		}// fin del for 
		
	}// fin del modifyCar
	
}