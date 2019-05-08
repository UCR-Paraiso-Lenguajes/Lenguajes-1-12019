package cr.ac.ucr.ie.business;

import cr.ac.ucr.ie.Domain.Carro;
import cr.ac.ucr.ie.Domain.CarroInterface;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Registro implements CarroInterface{
	
	
	private Logger salidaMensaje = Logger.getLogger("Control");
	private ArrayList<Carro> carroLista = new ArrayList<Carro>();
	private Carro carroVacio;
	
	public void añadirCarro (Carro car) {
		
		carroLista.add(car);
		salidaMensaje.log(Level.INFO, "The car was successfully registered.");
		
	}// addCar
	
	/* Capitulo 7 - Tip 7
	 * No delvolver NULL
	 * Minimizar la presencia 
	 * de NullPointerException.
	 */
	public Carro buscarCarro (short id) {
		
		/* Capitulo 7 - Tip 2
		 * Crear primero la instrucción 
		 * de try-catch finally.
		 * 
		 */
		
		try { 
			
				for (int indexSize = 0; indexSize < carroLista.size(); indexSize++) {
						
					  if (carroLista.get(indexSize).getIdCarro() == id) 
						  return carroLista.get(indexSize); // fin del if 
					    
				}// fin del for 
				
		     } catch(Exception e) {
		    	 salidaMensaje.log(Level.WARNING, null, e.getStackTrace()); 
		    	 carroVacio = new Carro();
		 		 return carroVacio;
		     } finally { 
		    	 salidaMensaje.log(Level.INFO,"The system search Car close");  
		     } 
		
		carroVacio = new Carro();
		return carroVacio;
	
	}// fin de searchCar
	
	
	public String mostrarListaCarro () {
		
		String carListComplet = "";
		
		for (int indexSize = 0; indexSize < carroLista.size(); indexSize++) {
			
			carListComplet += carroLista.get(indexSize).toString() + '\n';
			
		}
		
		carListComplet+='\n';
		return carListComplet;
		
	}
	
	public void eliminarCarro (short id){
		
		for (int indexSize = 0; indexSize < carroLista.size(); indexSize++) {
			
		    if (carroLista.get(indexSize).getIdCarro() == id)  {
		    	
		    	carroLista.remove(indexSize);
		    	salidaMensaje.log(Level.INFO,"The car with the requested "
		    			+ "id number: "+id+" was found and removed.\n"); 
		    	
		    }else salidaMensaje.log(Level.WARNING,"The requested car was not found.\n");
		    
		}// fin del for 
	
	}// fin de deleteCar
	
	public void modificarCarro (Carro carro) {
		
		short id = carro.getIdCarro();
		
		for (int indexSize = 0; indexSize < carroLista.size(); indexSize++) {
			
		    if (carroLista.get(indexSize).getIdCarro() == id) {
		    	
		    	carroLista.remove(indexSize); 
		    	salidaMensaje.log(Level.INFO,"The car with the requested id number: "+id+" was found and modified.\n"); 
		    	carroLista.add(carro);
		    	
		    }else salidaMensaje.log(Level.WARNING,"The requested car was not found.\n");
		    
		    
		}// fin del for 
		
	}// fin del modifyCar
	
}