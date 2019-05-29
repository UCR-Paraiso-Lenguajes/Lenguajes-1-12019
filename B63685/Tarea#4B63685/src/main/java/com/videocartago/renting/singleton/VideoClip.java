package com.videocartago.renting.singleton;

public class VideoClip {
	
	
	private String autor;
	private String nombreClip;
	
	public VideoClip(String autor, String nombreClip) {
		super();
		this.autor = autor;
		this.nombreClip = nombreClip;
		
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getNombreClip() {
		return nombreClip;
	}
	public void setNombreClip(String nombreClip) {
		this.nombreClip = nombreClip;
	}
	
	

}
