package cr.ac.ucr.ie.tarea;
import java.util.logging.Level;
import java.util.logging.Logger;
import cr.ac.ucr.ie.domain.Estudiante;
import cr.ac.ucr.ie.domain.Estudiantes;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest 
    extends TestCase
    
{
    public AppTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testApp()
    {
        assertTrue( true );
    }
    private final static Logger LOGGER = Logger.getLogger("");
   
    /*Todo codigo debe tener sus pruebas para comprobar que todo va funcionando correctamente*/
    Estudiante estudiante = new Estudiante();
    public void pruebaInsertarEstudiante() {
    	
    	Estudiantes estudiante1 = new Estudiantes("Jeremy", "Fonseca",73027);
    	Estudiantes estudiante2 = new Estudiantes("Camila", "Mendez",74507);
    	Estudiantes estudiante3 = new Estudiantes("Maurico", "Gomez",76927);
    	estudiante.AgregarEstudiante(estudiante1);
    	estudiante.AgregarEstudiante(estudiante2);
    	estudiante.AgregarEstudiante(estudiante3);
    
    }
    
    public void pruebaMostrarEstudiante() {
    	
    	LOGGER.log(Level.INFO,estudiante.MostrarEstudiantes());
    
    }
    
}
