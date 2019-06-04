package com.chat.domain;

import com.chat.exeption.chatException;

public class UserAdmin {

	private int id;
	private String password;
	private String avatar;
	private String email;
	private String name;
	private Rol rol;

	public UserAdmin() {
		super();
	}

	public UserAdmin(int id, String password, String avatar, String email, String name, Rol rol) {
		super();
		if (id < 0)
			throw new chatException("El id del usuario debe ser mayor  0.");
		if (password == null || password.trim().equals(""))
			throw new chatException("La contrasena es requerida");
		if (avatar == null || avatar.trim().equals(""))
			throw new chatException("El avatar requerido");
		if (email == null || email.trim().equals(""))
			throw new chatException("El email requerido");
		if (name == null || name.trim().equals(""))
			throw new chatException("El nombre requerido");
		if (rol == null)
			throw new chatException("El rol requerido");

		this.id = id;
		this.password = password;
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

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", avatar=" + avatar + ", email=" + email + "]";
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

}
