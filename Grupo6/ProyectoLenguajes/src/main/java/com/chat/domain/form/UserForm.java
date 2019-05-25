package com.chat.domain.form;

import java.util.Iterator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.chat.domain.UserAdmin;

public class UserForm {

	@NotNull
	@Min(2)
	private int codUser;
	@NotNull
	@Size(min=2, max=500)
	private String password;
	
	public UserForm() {
		super();
	}

	public int getCodUser() {
		return codUser;
	}

	public void setCodUser(int codUser) {
		this.codUser = codUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserForm [codUser=" + codUser + ", password=" + password + "]";
	}




}
