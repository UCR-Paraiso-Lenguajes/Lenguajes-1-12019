package com.tarea.refugio.domain;

public abstract class Animal {
	private String nombre;
	private int edad;
	private boolean esterilizado;
	private int peso;
	private boolean sociable;
	

	public Animal(String nombre, int edad, boolean esterilizado, boolean sociable, int peso) {
		this.setNombre(nombre);
		this.setEdad(edad);
		this.setEsterilizado(esterilizado);
		this.setSociable(sociable);
		this.setPeso(peso);
	}

	abstract int cantidadComidadPorMes();//Implementa un diferente calculo dependiendo del animal al que herede pg 93.
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().equals("")) 
			throw new RuntimeException("El nombre es requerido");//Uso de exceptions cuando se encuentra un error pg104.linux
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		if(edad < 0)
			throw new RuntimeException("La edad no es valida");
		this.edad = edad;
	}

	public boolean isEsterilizado() {
		return esterilizado;
	}

	public void setEsterilizado(boolean esterilizado) {
		this.esterilizado = esterilizado;
	}
	
	public boolean isSociable() {
		return sociable;
	}

	public void setSociable(boolean sociable) {
		this.sociable = sociable;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		if(peso < 0)
			throw new RuntimeException("La edad no es valida");
		this.peso = peso;
	}	
}
