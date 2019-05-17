package com.chat.domain;

public class User {

	private int id;
	private String password;

	public User(int id, String password) {
		super();
		if (id < 0)
			throw new RuntimeException("El id del usuario debe ser mayor  0.");
		if (password == null || password.trim().equals(""))
			throw new RuntimeException("La contraseña es requerida es requerido");
		this.id = id;
		this.password = password;
	}

	public User() {
		super();
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

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + "]";
	}

}
package com.chat.domain;

public class User {

	private int id;
	private String password;

	public User() {
		super();
	}

	public User(int id, String password) {
		super();
		this.id = id;
		this.password = password;
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

	
	
	
	
}
