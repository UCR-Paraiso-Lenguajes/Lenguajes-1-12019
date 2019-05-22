package com.lenguajes.ucrmsn.ucr.live.messenger.domain;

import java.util.Date;

public class Enlace {

	private Date date;
	private String hashCode;
	
	public Enlace(String hashCode) {
		super();
		this.date = new Date();
		this.hashCode = hashCode;
	}

	public Date getDate() {
		return date;
	}

	public String getHashCode() {
		return hashCode;
	}	
}
