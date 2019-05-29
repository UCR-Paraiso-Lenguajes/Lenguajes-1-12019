package com.orbis.b73331.domain;

public class Editorial {
	private int id_editorial;
	private String nombre;
	private String direccion;
	private String telefono;
	public Editorial(int id_editorial, String nombre, String direccion, String telefono) {
		if(id_editorial ==0) throw new OrbisExcepcion("El id editorial viene vacio");
		if(nombre.equals("") || direccion.equals("") || telefono.equals("")) throw new OrbisExcepcion("Se encuentran datos vacíos");
		this.id_editorial = id_editorial;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	public Editorial() {
	}

	public int getId_editorial() {
		if(id_editorial ==0) throw new OrbisExcepcion("El id editorial viene vacio");
		return id_editorial;
	}
	public void setId_editorial(int id_editorial) {
		if(id_editorial ==0) throw new OrbisExcepcion("El id editorial viene vacio");
		this.id_editorial = id_editorial;
	}
	public String getNombre() {
		if(nombre.equals("") || nombre==null) throw new OrbisExcepcion("El nombre viene vacio");
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre.equals("") || nombre==null) throw new OrbisExcepcion("El nombre viene vacio");
		this.nombre = nombre;
	}
	public String getDireccion() {
		if(direccion.equals("") || direccion==null) throw new OrbisExcepcion("La direccion viene vacia");
		return direccion;
	}
	public void setDireccion(String direccion) {
		if(direccion.equals("") || direccion==null) throw new OrbisExcepcion("La direccion viene vacia");
		this.direccion = direccion;
	}
	public String getTelefono() {
		if(telefono.equals("") || telefono==null) throw new OrbisExcepcion("El telefono viene vacio");
		return telefono;
	}
	public void setTelefono(String telefono) {
		if(telefono.equals("") || telefono==null) throw new OrbisExcepcion("El telefono viene vacio");
		this.telefono = telefono;
	}
	
	
	
	
}
