package com.fabricadealimentos.empleados.dominio;



public class Empleado {
	private int id;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String telefono;
	private float salario;
	
	
	
	
	public Empleado(int id, String nombre, String apellidos, String direccion, String telefono, int salario)
	{
		if(id <= 0) throw new RuntimeException("El id debe ser mayor a 0.");
		if(nombre == null || nombre.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		if(apellidos == null || apellidos.trim().equals("")) throw new RuntimeException("Los apellidos son requeridos");
		if(direccion == null) throw new RuntimeException("La direccion es requerida");
		if(telefono == null) throw new RuntimeException("El telefono es requerido");
		if(salario <= 0) throw new RuntimeException("El salario debe ser mayor a 0.");
		//capitulo 7, usar excepciones en lugar de codigo devuelto
		
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.salario = salario;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) 
	{
		if(id <= 0) throw new RuntimeException("El id debe ser mayor a 0.");
		this.id = id;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		if(nombre != null && nombre.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		this.nombre = nombre;
	}

	public String getApellidos() 
	{
		return apellidos;
	}

	public void setApellidos(String apellidos)
	{
		if(apellidos != null && apellidos.trim().equals("")) throw new RuntimeException("El apellidos es requerido");	
		this.apellidos = apellidos;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public float getSalario() {
		return salario;
	}



	public void setSalario(float salario) {
		this.salario = salario;
	}

	
}
