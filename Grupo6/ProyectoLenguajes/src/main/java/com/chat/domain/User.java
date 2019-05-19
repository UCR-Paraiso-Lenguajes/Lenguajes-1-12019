package com.chat.domain;

public class User {

	private int id;
	private String name;
	private String password;
	private String avatar;
	private String email;

	public User() {
		super();
	}

	public User(int id, String name, String password, String avatar, String email) {
		super();
		if (id < 0)
			throw new RuntimeException("El id del usuario debe ser mayor  0.");
		if (password == null || password.trim().equals(""))
			throw new RuntimeException("La contrasena es requerida");
		if (avatar == null || avatar.trim().equals(""))
			throw new RuntimeException("El avatar es requerido");
		if (email == null || email.trim().equals(""))
			throw new RuntimeException("El email es requerido");
		if (name == null || name.trim().equals(""))
			throw new RuntimeException("El nombre es requerido");

		this.id = id;
		this.password = password;
		this.avatar = avatar;
		this.email = email;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", avatar=" + avatar + ", email=" + email + "]";
	}

}
