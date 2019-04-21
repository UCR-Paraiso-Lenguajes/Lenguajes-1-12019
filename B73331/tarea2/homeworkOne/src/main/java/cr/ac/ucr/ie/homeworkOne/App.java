package cr.ac.ucr.ie.homeworkOne;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import cr.ac.ucr.ie.dataContainer.DataList;
import cr.ac.ucr.ie.domain.Cow;
import cr.ac.ucr.ie.domain.CowController;

/**
 * Aplicacion de los tips de la lectura
 *
 */
public class App 
{
    private static Logger logger = Logger.getLogger("cr.ac.ucr.ie.homeworkOne.App");
	
    public static void main( String[] args )
    {
    	//Tip #1 Explicar la funcion del metodo  y para que se usa
    	/**En el metodo main es en donde construyo el menu de la aplicacion para poder irme de una clase
    	 * a otra y poder hacer el CRUD del objeto "vaca"
    	**/
    	//Tip #2 nombres cortos en variables
    	//Tip #3 Secciones dentro de funciones (declaracion de variables, inicializarlas y operaciones)
    	DataList dataList = new DataList();
    	dataList.listOfCows =  new ArrayList<>();
    	
    	/**
    	Tip #10 Nombre de variables, funciones, claves deben decir por que de la existencia,
   	  	que hacen y como se usan
   	 	**/
        byte flag = 1; //Flag es la variable que le indica al menu cual accion el usuario quiere realizar
        Scanner scannerReader = new Scanner(System.in);
        CowController cowController = new CowController();
        logger.log(Level.INFO,"Welcome to the farm application");
        showMenu();
        flag = scannerReader.nextByte();
        // Tip #4 Bloques y Sangrias en el codigo
        while(flag!=0) {
        	
        	try {
        	if(flag<0 || flag >=5) {
        		logger.log(Level.INFO,"Number selected is not correct please enter an autorized one");
        		
        	}else if(flag==1) {
        		logger.log(Level.INFO,"Insert the values in this order: 1.Number of the cow, \"\r\n" + 
        				"        				+ \"2.Age of the cow, 3.Race of the cow");
        		Cow cowToInsert = new Cow(scannerReader.nextInt(),scannerReader.nextInt(),scannerReader.next());
        		cowController.insertACow(cowToInsert);
        		
        	}else if(flag==2){
        		logger.log(Level.INFO,"Plese choose the number of the cow that you want to delete");
        		cowController.listAllCows();
        		cowController.delteACow(scannerReader.nextByte());
        		
        	}else if(flag==3){
        		cowController.listAllCows();
        		logger.log(Level.INFO,"Plese choose the number of the cow that you want to update");
        		int cowPossition = scannerReader.nextByte();
        		logger.log(Level.INFO,"Insert the values of the new cow in this order: 1.Number of the cow, \"\r\n" + 
        				"        				+ \"2.Age of the cow, 3.Race of the cow");
        		Cow cowToInsert = new Cow(scannerReader.nextInt(),scannerReader.nextInt(),scannerReader.next());
        		cowController.updateACow(cowPossition, cowToInsert);
        		
        	}else if(flag==4){
        		cowController.listAllCows();
        	}//End if
        	showMenu();
        	flag = scannerReader.nextByte();
    		
        	}catch (Exception exception) 	{
        		logger.log(Level.INFO,"The number selected is not an autorized one");
        		flag = 0;
			}//End catch
        }//End whie
        logger.log(Level.INFO,"Thank's for using the app, good luck!");
    
    }
    public static void showMenu() {
    	//Tip #1 Explicar la funcion del metodo  y para que se usa
    	/**
    	 * Metodo que me muestra el String explicativo del menu y me 
    	 * ahorra lineas de codigo en el main
    	 * */
    	logger.log(Level.INFO,"Press '0' to finish"+"\n"
				+"Press '1' to add a cow to the farm "+"\n"
				+"Press '2' to remove a cow of the farm list"+"\n"
				+"Press '3' to update a cow on the farm list"+"\n"
				+"Press '4' to list all the cows of the farm ");
    }
    
    
    
}