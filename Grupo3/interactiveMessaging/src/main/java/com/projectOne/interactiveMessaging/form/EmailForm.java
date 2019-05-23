package com.projectOne.interactiveMessaging.form;

import javax.validation.constraints.NotNull;

public class EmailForm {
	@NotNull
	private String[] emailsSel;

	public String[] getEmailsSel() {
		return emailsSel;
	}

	public void setEmailsSel(String[] emailsSel) {
		this.emailsSel = emailsSel;
	}
}
