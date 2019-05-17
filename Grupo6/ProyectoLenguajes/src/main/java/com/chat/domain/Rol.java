package com.chat.domain;

public class Rol {

	private int id;
	private String name;

	public Rol(int id, String name) {
		super();
		if(id <0) throw new RuntimeException("El id del Rol debe ser mayor  0.");
		if(name == null || name.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		this.id = id;
		this.name = name;
	}

	public Rol() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", name=" + name + "]";
	}

}
