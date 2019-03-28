package cr.ac.ucr.tarea3.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import cr.ac.ucr.domain.*;
import cr.ac.ucr.tare3.exception.ExcepcionEmpleados;

public class EmpleadoData implements EmpleadoInterface {

	public List<Empleado> lista = new ArrayList<Empleado>();
	
	/*El fin de utilizar interfaces es llegar a un punto de abstraccion.
	 * Esta tiene el fin de que las personas solamente utilicen lo necesario y no
	 * realicen cambios en el contenido de los Objetos durante el flujo a menos que 
	 * la interface provea algún metodo que lo permita. Protegiendo de esta manera
	 * la estructura de los Objetos y por ende la información (Data Abstraction paginas 93-94)*/
	
	public EmpleadoInterface obtenerEmpleado(int cod) {
		// TODO Auto-generated method stub
		return null;
	}

	public double obtenerSalarioPorFuncionario(int cod) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void cambiarFechaSalidaEmpresa(Date fecha) {
		// TODO Auto-generated method stub
		
	}

	/*Este punto se centra en diferenciar cuando estamos haciendo uso de un objeto
	 * y cuando estamos utilizando una estructura de datos. Los objetos esconden sus atributos
	 * bajo el principio de abstracción y los exponen mediante metodos para modificar la data.
	 * Las estructuras de datos por otra parte exponen su contenido y sus funciones no
	 * tienen un significado muy importante pero si funcional (Data/Object Anti Symemtry paginas 95-96-97)*/
 
	public void mostrarEstructura() {
		
		Empleado emp = new Empleado();
		
		String info = emp.toString();
		
		List<Empleado> listaEmpleados = new ArrayList<Empleado>();
		
		listaEmpleados.add(emp);
		
		/*En este caso se esta mostrando la información de un objeto que esta vacio pero a travez
		 * de un metodo que respeta el principio de abstracción. Por otra parte la estructura
		 * ArrayList puede ser manipulada sin control alguno e ingresar un objeto sin contenido sin ningun
		 * problema*/
	}
	
	/*La ley de demeter consiste en no utilizar metodos que no son propios de la clase que utilizamos
	 * Visto a forma de ejemplo muchisimas clases como la String cuentan con gran cantidad de metodos que
	 * se encuentran dentro de una interface y uno simplemente los utiliza sobre las variables que se declaran
	 * bajo este tipo de clase para interactuar de manera más simple con este objeto de clase tipo String
	 * Si usamos un metodo externo a esta clase estamos incumpliendo la ley de Demeter y exponiendo de forma
	 * inadecuada la información(Law of Demeter paginas 97-98)*/

     public String obtenerInformaciónEmpleado() {
    	 
    	 Empleado emp = new Empleado();
    	 
    	 Object obj = emp.getClass();
    	 
    	 return obj.toString();
    	 /*En esta ocasion podriamos obtener la información del Objeto empleado a traves de sus 
    	  * o utilizando la interface que creamos para mantener la data abstracta. Al castearla a 
    	  * la clase Object que tiene una jerarquia más alta permite manipular el objeto e incluso usar
    	  * metodos distintos sobre lo que antes era un Empleado */
     }
	
     
     /*El uso de objetos de transferencia de datos se ve cuando se interactua con bases de datos o en caso
      * de recibir información mediante sockets. Lo importante es poder determinar el contenido de la estructura
      * y como trabajar con esta. Se deben separar los Objetos pertenecientes de la logica de negocio de los
      * datos que no tienen que con esto y quizas tienen otro fin. Esto con el fin de no producir un Objeto Hibrido
      * que complique su manipulación. (Data Transfer Objects paginas 100-101)*/
     
     public Empleado obtenerInformacionBaseDatos(ResultSet rs) throws SQLException {
    	 
    	 Empleado emp = new Empleado();
    	 
    	 /*Empleado parte de la logica de negocio*/
    	 emp.setNombre(rs.getString("nombre"));
    	 /*Parte de lo traido en alguna consulta de Base de Datos con un fin distinto*/
    	 String condicion = String.valueOf(rs.getByte(1));
    	 
    	 return emp;
     }
     
     /*Esto principalmente mantener el principio de que los metodos deberian tener 
      * solamente un return. Ademas de esto los returns terminan todo el flujo
      * las excepciones arrojan donde se dio el error y el tipo si se valido correctamente
      * (Use Exceptions Rather Than Return Codes / Usar Excepciones en lugar de returns Pag 104)*/
     
     
     public void insertarEmpleado(Empleado emp) throws ExcepcionEmpleados {

 		List<Empleado> lista = new ArrayList<Empleado>();

 		
 		/*Es cuestion de entender los niveles en que utilizamos las sentencias
 		 * Catch principalmente. Estas pueden pasar por distintos niveles inferiores
 		 * y hasta llegar a la sentencia catch se va disparar la exception. Para esto el try
 		 * cuenta con su función de envolver el trozo de codigo donde se puede disparar la excepcion"
 		 * (Usar unchecked Exceptions pag 106)*/
 		try {

 			if (lista.isEmpty() || emp.toString().equals("")) {
 				throw new ExcepcionEmpleados("Lista u Empleado sin datos");
 			}

 		} catch (Exception msg) {

 			/*Permite determinar la razon por la que se disparo la excepcion
 			 * bajo casos especificos. Aún más importante dice cual puede ser el motivo
 			 * siempre y cuando la validación este bien hecha 			 * 
 			 * (Proveer contexto con las excepciones pag 107)*/
 			throw new ExcepcionEmpleados("Datos incompletos");

 		}

 		/*Esto con el fin de utilizar bien las excepciones en un principio.
 		 * La estructura Try se asegura de que no importe si algo va mal
 		 * el catch va a estar para detener, arrojar la excepcion y cortar el flujo
 		 * evaluado en el Try. El finally tomara un acción correctiva al final.
 		 * (Escribir las sentencias Try - Catch- Finally primero)*/
 		finally {

 			if (!lista.isEmpty() && !emp.toString().equals("")) {
 				lista.add(emp);
 			} else {
 				throw new ExcepcionEmpleados("Datos incompletos");
 			}

 		}

 	}
     
     /*Para esto es buena practica validar que los valores no sean null
      * (Evitar devolver Null pag 112)*/
     public String obtenerNombreEmpleado(int identificacion) throws ExcepcionEmpleados {
		
    	 String nombre="";
    	 String apellidos="";
    	 int cantidadIncompletos=0;
    	 
    	 for (int i = 0; i < lista.size(); i++) {
			Empleado emp = (Empleado)lista.get(i);
			if(emp.getIdentificacion()==identificacion) {
				if(emp.getNombre() != null && emp.getApellidos() != null) {
				nombre = emp.getNombre();
				apellidos = emp.getApellidos();
				}else {
					/*Un contador interno puede llevar un historial del flujo dentro de la 
					 * estructura y determinar para esta ocasión
					 * cuantos Empleados tienen la información incompleta
					 * (Define the normal Flow pagina 109)*/
					cantidadIncompletos++;
	 				throw new ExcepcionEmpleados("Datos incompletos");
				}
			}
		}
    	 
    	 /*Con una validación sobre la estructura se puede evitar que ocupa esto
    	  * (Evita pasar null pagina 111)*/
    	 if(lista.isEmpty()) {
    	      return "No se encontraron registros";
    	 }
			return nombre+" "+apellidos;
		}
}
