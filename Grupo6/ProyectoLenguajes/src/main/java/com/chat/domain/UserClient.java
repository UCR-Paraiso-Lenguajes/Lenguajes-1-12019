package com.chat.domain;

public class UserClient {

	private int id;
	private String avatar;
	private String email;
	private String name;
	private Rol rol;
	
	public UserClient() {
		
	}
	
	public UserClient(int id, String avatar, String email, String name, Rol rol) {
		super();
		if (id < 0)
			throw new RuntimeException("El id del usuario debe ser mayor  0.");
		if (avatar == null || avatar.trim().equals(""))
			throw new RuntimeException("El avatar requerido");
		if (email == null || email.trim().equals(""))
			throw new RuntimeException("El email requerido");
		if (name == null || name.trim().equals(""))
			throw new RuntimeException("El nombre requerido");
		if (rol == null)
			throw new RuntimeException("El rol requerido");

		this.id = id;
		this.avatar = avatar;
		this.email = email;
		this.setName(name);
		this.setRol(rol);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "UserClient [id=" + id + ", avatar=" + avatar + ", email=" + email + ", name=" + name + ", rol=" + rol
				+ "]";
	}
	
}
