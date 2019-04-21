package cr.ac.ucr.ie.tarea;

import java.util.Scanner;

import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import cr.ac.ucr.ie.domain.Estudiante;
import cr.ac.ucr.ie.domain.Estudiantes;

/* El sangrado del codigo tiene que estar adecuado para que la lectura sea mas facil*/
public class App 
{
	private final static Logger LOGGER = Logger.getLogger("");
	
    public static void main( String[] args )
    {
    	Estudiante estudiante = new Estudiante();
    	
    	Scanner lectordeConsola = new Scanner(System.in);
    	int numeroIngresado=1;
       
        /* El ciclo esta de forma correcta para que no haga recorridos innecesarios y gaste memoria*/
        while(numeroIngresado>0 && numeroIngresado<=3) {
        	LOGGER.log(Level.INFO, "Igrese el numero segun lo deseado"+"\n"+"1 para agregar un estudiante"+"\n"
 					+"2 para eliminar un estudiante"+"\n"+"3 para mostrar la lista de los estudiantes"
 					+"\n"+"4 para salir del menu");
        	 try {
        		 numeroIngresado = lectordeConsola.nextInt();
        
        		if(numeroIngresado==1) {
        			LOGGER.log(Level.INFO,"Ingrese el nombre, apellidos y carnet en su respectivo orden");
        			Estudiantes estudiante1 = new Estudiantes(lectordeConsola.next(), lectordeConsola.next(), lectordeConsola.nextInt());
        			estudiante.AgregarEstudiante(estudiante1);
        		}else if(numeroIngresado==2) {
        			LOGGER.log(Level.INFO,"Ingrese el nombre del estudiante a eliminar");
        			estudiante.EliminarEstudiante(lectordeConsola.next());
        		}else if(numeroIngresado==3) {
        			LOGGER.log(Level.INFO,estudiante.MostrarEstudiantes());
        		}
        	}catch(Exception ex){
        		LOGGER.log(Level.INFO,"No se puede ingresar una letra solo numeros");
        		numeroIngresado=0;
        		
        	}
        	
        }
        
        
        
        
    }
}
