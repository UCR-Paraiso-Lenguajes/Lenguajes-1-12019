package com.chat.domain.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RolForm {

	@NotNull
	@Min(1)
	private int id;
	@NotNull
	private String name;
	public RolForm() {
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
		return "RolForm [id=" + id + ", name=" + name + "]";
	}
	
	
}
