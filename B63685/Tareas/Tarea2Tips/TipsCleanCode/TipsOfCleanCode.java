package TipsCleanCode;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TipsOfCleanCode {

	// TIPS CAPÍTULO DOS

	// Tip 1: Use intention-Revealing Names Page 18 

	int s = 1000000; // incorrect
	
	public void s() {
		
		Employee employee = new Employee();
		
		if(s>1200000) {
			employee.setSalary(1100000);
		}else {
			employee.setSalary(1000000);
		}
	}
	
	int amountSalaryPerEmployee = 1000000; // correct
	
	public void amountSalaryPerEmployee() {
		
		Employee employee = new Employee();
		
		if(amountSalaryPerEmployee>1200000) {
			employee.setSalary(1100000);
			
		}else {
			
			employee.setSalary(1000000);
		}
	}

	// Tip: 2 Avoid desinformation Page 19

	String pl2; // incorrect
	
	public String pl2() {
		
		pl2 = "X^2+x+4";
		
		return pl2;
	}
	
	String polynomialGradeTwo; // correct
	
	public String polynomialGradeTwo() {
		
		polynomialGradeTwo = "X^2+X+4";
		
		return polynomialGradeTwo;
	}

	// Tip: 3 Make meaningful distinctions Page 20

	public void insertStudent(String student) {

		ArrayList<String> students = new ArrayList<>();
		students.add(student);
	}

	public void addStudent(String student) {
		
		Logger logger = Logger.getLogger("My Logger");
		logger.log(Level.WARNING, "Remember add student");
	}

	//Tip 4: Use a pronounceable names Page 21

	public void nOC() {
		String nOC = "María Jiménez"; // incorrect (abbreviation to name Of Customer)
		Logger logger = Logger.getLogger("MYLOOGER");
		
		if(nOC.equalsIgnoreCase("María Jiménez")) {
			logger.log(Level.INFO, "Es un cliente frecuente");
		}
	}
		public void nameOfCustomer() {
			String nameOfCustomer = "María Jiménez"; // correct name
			Logger logger = Logger.getLogger("MYLOOGER");
			
			if(nameOfCustomer.equalsIgnoreCase("María Jiménez")) {
				logger.log(Level.INFO, "Es un cliente frecuente");
			}
	}

	//Tip 5: Don't be cute Page 26
	
	public void goToShopping(ArrayList products) {// incorrect (it's a joke)
			
			products.add("Shampoo");
	}

	public void supermarketProductList(ArrayList productsList) { // correct

			productsList.add("Shampoo");

	}

	// CAPITULO 3

	//Tip 6: Fuction Small! Page 34

	public void discountEmployeeSalary(Employee employee) {

		ArrayList<Employee> employees = new ArrayList<>();

		employees.add(employee);
	}

	//Tip 7: Use descriptive names Page 39

	public String a(String s) {// INCORRECT!!
		return s;
	}

	public String nameEmployee(String name) {// CORRECT
		return name;
	}

	//Tip 8: Arguments Objects Page 43 

	public Employee returnEmployee(int id, String name, String address, int salary) {// incorrect, many arguments

		Employee employee = new Employee(id, name, address, salary);

		return employee;

	}

	public Employee personalInformationEmployee() {//for improve, it's separate in two methods

		Employee employee = new Employee();
		String name = employee.getName();
		String address = employee.getAddress();
		Employee personalInformationEmployee = new Employee(name, address);
		return personalInformationEmployee;

	}

	public Employee idAndSalaryEmployee() {

		Employee employee = new Employee();
		int id = employee.getIdEmployee();
		int salary = employee.getSalary();

		Employee idAndSalaryEmployee = new Employee(id, salary);

		return idAndSalaryEmployee;

	}

	// therefore the method would be as follows (using tip Arguments Object Page 43):

	public Employee returnEmployee() { // "The ideal number of arguments for a function is zero (niladic)." (page 40, paragraph 4)

		Employee personalInformation = personalInformationEmployee();
		Employee idAndSalary = idAndSalaryEmployee();

		Employee completeEmployee = new Employee(idAndSalary.getIdEmployee(), personalInformation.getName(),
				personalInformation.getAddress(), idAndSalary.getSalary());

		return completeEmployee;

	}

	// Tips 9: Prefer exception to returning error codes Page 46

	public void connectFromDatabase() {
		
	Logger logger = Logger.getLogger("MYLOOGER");
	Connection connectToDatabase = null;
	String sURL = "jdbc:mysql://localhost:3306/databaseAlfonsoPrueba";
	
	try (PreparedStatement stmt = ((java.sql.Connection) connectToDatabase).prepareStatement("SELECT name FROM Employee")) {
		
		  connectToDatabase = (Connection) DriverManager.getConnection(sURL,"Alfonso","1234");
		  
		  ResultSet rs = stmt.executeQuery();
		 
		  while (rs.next())
		    logger.log(Level.INFO,rs.getString("Employee"));
		 
		} catch (SQLException sqle) { 
			
			  logger.log(Level.WARNING,"ERROR, THE CONNECTION TO THE DATABASE COULDN'T BE MADE!!");
		 
		}

	// tip 10: Block and indenting page 35

	public void monthSwitchBadIdenting(int month) {// incorrect

Logger logger = Logger.getLogger("MYLOOGER");

switch (month) {
case 1:
logger.log(Level.INFO, "January");

case 2:
					logger.log(Level.INFO, "February");

case 3:
				logger.log(Level.INFO, "March");
				case 4:
logger.log(Level.INFO, "April");
					case 5:
						
						
			logger.log(Level.INFO, "May");

case 6:
					logger.log(Level.INFO, "June");
		case 7:	logger.log(Level.INFO, "July");
		case 8:
logger.log(Level.INFO, "August");
		case 9:
	logger.log(Level.INFO, "September");
case 10:
			logger.log(Level.INFO, "October");
		case 11:
			logger.log(Level.INFO, "November");
case 12:
logger.log(Level.INFO, "December");
			break;
default:
			month = 0;
		}

	}

	public void monthSwitchGoodIdenting(int month) {// correct

		Logger logger = Logger.getLogger("MYLOOGER");

		switch (month) {
		case 1:
			logger.log(Level.INFO, "January");

		case 2:
			logger.log(Level.INFO, "February");

		case 3:
			logger.log(Level.INFO, "March");
		case 4:
			logger.log(Level.INFO, "April");
		case 5:
			logger.log(Level.INFO, "May");
		case 6:
			logger.log(Level.INFO, "June");
		case 7:
			logger.log(Level.INFO, "July");
		case 8:
			logger.log(Level.INFO, "August");
		case 9:
			logger.log(Level.INFO, "September");
		case 10:
			logger.log(Level.INFO, "October");
		case 11:
			logger.log(Level.INFO, "November");
		case 12:
			logger.log(Level.INFO, "December");
			break;
		default:
			month = 0;
		}

	}

}
