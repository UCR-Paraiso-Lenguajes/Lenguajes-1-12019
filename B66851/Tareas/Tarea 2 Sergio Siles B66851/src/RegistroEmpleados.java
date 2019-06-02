
import dominio.Empleado;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fabian
 */
public class RegistroEmpleados {
    
    ArrayList<Empleado> empleadosRegistrados = new ArrayList(); 
    //tip: los nombres de los metodos deben ser verbos.
    //tip : la selección de nombres correctos mejora la explicación de su cometido.
    public Empleado consultarEmpleadoPorIdentificacion(String IdentificacionEmpleadoABuscar){
        //tip : es importante utilizar nombre descriptivos en los metodos, ya que en un futuro nos ayudarán a comprender el código.
        int iteradorEmpleado;
        for (iteradorEmpleado = 0; iteradorEmpleado < empleadosRegistrados.size(); iteradorEmpleado++) {
            if(empleadosRegistrados.get(iteradorEmpleado).getIdentificacion().equalsIgnoreCase(IdentificacionEmpleadoABuscar)){
                return empleadosRegistrados.get(iteradorEmpleado);
                //tip: evitar usar los argumentos de salida, en POO se utiliza el return que soluciona este problema.
            }
        }
        return null;
    }
    
    //tip: funciones diádicas, es mejor evitarlas y utilizar las monádicas.
    //tip: formas monádicas, existen motivos para pasar solo un argumento a una función.
    public boolean existeEmpleadoEnRegistro(String IdentificacionEmpleadoABuscar){
        int iteradorEmpleado;
        for (iteradorEmpleado = 0; iteradorEmpleado < empleadosRegistrados.size(); iteradorEmpleado++) {
            if(empleadosRegistrados.get(iteradorEmpleado).getIdentificacion().equalsIgnoreCase(IdentificacionEmpleadoABuscar)){
                return true;
            }
        }
        return false;
    }
}
