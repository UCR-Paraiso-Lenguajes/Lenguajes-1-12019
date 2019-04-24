package TipsCleanCode;

public class Employee {
	
	private int idEmployee;
	private String name;
	private String address;
	private int salary;
	
	
	

	public Employee(int idEmployee, String name, String address, int salary) {
		super();
		this.idEmployee = idEmployee;
		this.name = name;
		
		this.address = address;
		this.salary = salary;
	}

	
	
	public Employee() {
		super();
	}



	public Employee(int idEmployee, int salary) {
		super();
		this.idEmployee = idEmployee;
		this.salary = salary;
	}



	public Employee(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}







	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	
	
	

}
