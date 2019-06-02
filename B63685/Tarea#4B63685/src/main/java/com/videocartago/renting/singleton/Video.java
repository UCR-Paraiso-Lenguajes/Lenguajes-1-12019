package com.videocartago.renting.singleton;

public class Video {
	
	private String extension;
	private String formato;
	
	public Video(String extension, String formato) {
		super();
		this.extension = extension;
		this.formato = formato;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	
	
	

}
