
package universidad;

import domain.Estudiante;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicole Fonseca
 */

/*Make Meaningful Distinctions
No utilizar palabras que ya se hayan utilizado para otras clases o variables.
Por ejemplo si se tiene la clase Product no usar en otra ProductInfo.
En este caso se tiene la clase Estudiante y para recolectar la información
del estudiante se utilizará la clase Matricula.
*/
public class Matricula {
    /*Reading Code from Top to Bottom: The Stepdown Rule.
    El Objetivo es que el código se lea como un texto de arriba a abajo.
    */
    
    ArrayList<Estudiante> estudiantes = new ArrayList<>();
    
    /*
    Small!
    Las funciones deben tener un tamaño reducido, ya que funcionan mejor que las funciones
    que tienen muchas líneas de código.
    */
    public void añadirEstudiante() {
        String id = JOptionPane.showInputDialog("Ingrese la identificación del estudiante");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
        String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos del estudiante");
        String carrera = JOptionPane.showInputDialog("Ingrese la carrera que desea matricular el estudiante");
        Estudiante estudiante = new Estudiante(id, nombre, apellidos, carrera);
        estudiantes.add(estudiante);
    }
    
    /*Do One Thing
    La función debe realizar una serie de pasos para un mismo objetivo.
    En este caso se muestra la información del estudiante según la identificación del mismo.
    */
    public void mostrarEstudiante() {

        String id = JOptionPane.showInputDialog("Ingrese la identificación del estudiante");
        String informacionEstudiante = "";
        /*Avoid Mental Mapping
        Evitar usar palabras que otros programadores no van a entender,
        por ejemplo usar letras en bucles.
         */
        for (int posicionEstudiante = 0; posicionEstudiante < estudiantes.size(); posicionEstudiante++) {
            /*Blocks and Indenting
            El nivel de sangría de una función no debe ser mayor de uno o dos.
            Para así entender mejor la función.
             */
            if (estudiantes.get(posicionEstudiante).getId().equals(id)) {
                informacionEstudiante += "Nombre: " + estudiantes.get(posicionEstudiante).getNombre() + "\n";
                informacionEstudiante += "Apellidos: " + estudiantes.get(posicionEstudiante).getApellidos() + "\n";
                informacionEstudiante += "Identificación: " + estudiantes.get(posicionEstudiante).getId() + "\n";
                informacionEstudiante += "Carrera: " + estudiantes.get(posicionEstudiante).getCarrera();
            }
        }
        JOptionPane.showMessageDialog(null, informacionEstudiante);
    }
}
