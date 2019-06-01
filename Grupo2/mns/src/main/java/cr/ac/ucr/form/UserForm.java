package cr.ac.ucr.form;

import javax.validation.constraints.NotNull;

public class UserForm {
	
	private int idUser;
	@NotNull
	private String email;
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email.trim().equalsIgnoreCase("") || email == null ) throw new RuntimeException("El email no puede estaar vacio");
		this.email = email;
	}
}