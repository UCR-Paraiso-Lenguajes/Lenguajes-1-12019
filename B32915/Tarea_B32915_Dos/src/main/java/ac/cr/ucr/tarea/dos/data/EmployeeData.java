package ac.cr.ucr.tarea.dos.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import ac.cr.ucr.tarea.dos.business.Employee;

public class EmployeeData {

	/*
	 * Capitulo 2 Pagina 25 Use Searchable Names: Single-letter names and numeric
	 * constants have a particular problem in that they are not easy to locate
	 * across a body of text... No es lo mismo nombrar a una variable simplemente
	 * int numero a ponerle cual es su valor dentro del flujo
	 */
	/*
	 * Capitulo 2 Pagina 23 Avoid Encodings Se debe evitar agregar nombres extensos
	 * o que compliquen o generen codificación excesiva
	 */

	double employeeSalary = payEmployee(1);

	/*
	 * Capitulo 2 Pagina 25 Method Names: "Methods should have verb or verb phrase
	 * names like postPayment, deletePage, or save" Se debe buscar que los metodos
	 * tengan nombres de verbos y que sean significativos o representen la
	 * funcionalidad realizada
	 */

	/*
	 * El metodo recibe un codigo y busca dentro de la lista de empleados en base al
	 * codigo recibido para encontrar el salario de esa persona
	 */
	public double getSalaryById(int cod) {

		double salary = 200.00;

		return salary;
	}

	/*
	 * Capitulo 3 pagina 48 "Dont Repeat Yourself": Evitar que las funciones o
	 * metodos repitan la estructura algoritmica interna. Aca podemos ver como la
	 * función payEmployee retorna el pago de un usuario en base a un employeeID. y
	 * en la parte de arriba el metodo getSalaryById realiza lo mismo y se puede
	 * obtener por medio de getSalary a traves de una instancia de la clase Employee
	 */
	public double payEmployee(int employeeID) {

		Employee emp = new Employee();
		double salary = 230.00;

		return salary;

	}

	/*
	 * Capitulo 3 pagina 48 Structured Programming ...should only be one return
	 * statement in a function, no break or continue statements in a loop, and
	 * never... Los return multiples son comunmente utilizados en la recursividad
	 * para detener los llamados internos a las funciones al alcanzar los casos
	 * bases. Por otra parte utilizar las sentencias continue o break son malas
	 * practicas de programación dentro de un ciclo ya que detienen abruptamente la
	 * secuencia o realizan un "salto" dentro de las iteraciones
	 */

	/*
	 * Capitulo 3 Pagina 47 "Error Handling Is One Thing": La utilización de las
	 * sentencias try y catch pueden bloquear un flujo inadecuado o que comprometa
	 * la integridad de los datos al terminar el flujo.
	 */

	public List<Employee> createEmployee() {

		ArrayList<Employee> listEmployee = new ArrayList<Employee>();

		Date date = new Date();

		for (int i = 0; i <= 20; i++) {

			try {
				listEmployee.add(new Employee("" + i, "Jose", "Miguel", "AB13155" + i, "Admin", date, 250.000));
			} catch (Exception e) {
				e.addSuppressed(new Exception());
			}

		}

		return listEmployee;
	}

}
