package com.projectOne.interactiveMessaging.form;

import java.util.ArrayList;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.projectOne.interactiveMessaging.domain.Role;

public class UserForm {
	@NotNull
	private int user_id;
	@Email
	@NotBlank //Es diferente a @NotEmpty, la diferencia es que ignora los espacios en blanco finales
	private String user_email;
	@NotNull
	@Valid
	private ArrayList <Role> roles;
	@NotNull
	private String hash;
	
	public UserForm() {
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public ArrayList<Role> getRoles() {
		return roles;
	}
	public void setRoles(ArrayList<Role> roles) {
		this.roles = roles;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	
	

}
