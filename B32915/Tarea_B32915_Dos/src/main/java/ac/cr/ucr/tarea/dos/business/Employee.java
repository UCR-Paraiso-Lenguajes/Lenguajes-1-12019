package ac.cr.ucr.tarea.dos.business;

import java.util.Date;

/*Capitulo 2 Pagina 25 Class Names: "Classes and objects should have noun or noun 
 phrase names like Customer, WikiPage, Account, and AddressParser. Avoid words like Manager..."
 Se debe tratar de utiizar sustantivos para nombrar las clases*/
public class Employee {

	/*
	 * Capitulo 3 Pagina 35 Blocks and identing: Dar formato o identar
	 * es importante para que el codigo se vea ordenado. En cuanto a los bloques
	 * es indispensable que las sentencias if-else o while no tenga validaciones excesivas
	 * de preferencia no más de una línea
	 */
	private String cod;
	private String firtsName;
	private String lastName;
	private String identification;
	private String rol;
	private Date dateBirth;
	private double salary;

	public Employee(String cod, String firtsName, String lastName, String identification, String rol, Date dateBirth,
			double salary) throws Exception {

		if(firtsName.equals(null)) {
			throw(new Exception("El valor de nombre debe aparecer"));
		}else if(lastName.equals(null)) {
			throw(new Exception("El valor de apellido debe aparecer"));			
		}else if(identification.equals(null)) {
			throw(new Exception("El valor de identificacion debe aparecer"));
		}
		
		this.cod = cod;
		this.firtsName = firtsName;
		this.lastName = lastName;
		this.identification = identification;
		this.rol = rol;
		this.dateBirth = dateBirth;
		this.salary = salary;
	}

	public Employee() {

	}
	/*
	 * Capitulo 3 Pagina 35 y 36: One Level of Abstraction per Function Function
	 * should do one thing and make it well.
	 * Los metodos get y set cumplen con sus funciones correctamente y dan un nivel de 
	 * encapsulamiento apropiado a los objetos. Tambien son cortas y efectivas
	 */

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getFirtsName() {
		return firtsName;
	}

	public void setFirtsName(String firtsName) {
		this.firtsName = firtsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
