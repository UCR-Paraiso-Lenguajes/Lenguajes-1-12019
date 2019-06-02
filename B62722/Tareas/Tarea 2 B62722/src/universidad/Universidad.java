
package universidad;

import javax.swing.JOptionPane;
/**
 *
 * @author Nicole Fonseca
 */
public class Universidad {

    public static void main(String[] args) {
        
        Matricula matricula = new Matricula();
        int opcion = 1;
        while (opcion != 0) {
            /*
            Prefer Exceptions to Returning Error Codes.
            En este caso se utiliza la excepción NumberFormatException 
            para validar que el usuario no pueda ingresar letras en el menú
            y solo las opciones que se le brinda, las cuales son solo números.
            */
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("Elija una opción del menú\n"
                        + "1. Añadir un nuevo estudiante\n"
                        + "2. Consultar información estudiante\n"
                        + "0. Salir"));
                switch (opcion) {
                    case 1:
                        matricula.añadirEstudiante();
                        break;
                    case 2:
                        matricula.mostrarEstudiante();
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        JOptionPane.showMessageDialog(null, "Opción incorrecta");
                        break;
                }
            } catch (NumberFormatException numberFormat) {
                JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }
}
