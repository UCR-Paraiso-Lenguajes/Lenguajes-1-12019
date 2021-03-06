package com.video.renting.domain;

public class SingletonProductora {
	
	private Pelicula peli;
	private Video video;
	private Clip clip;
	private static SingletonProductora singleton;
	
	private SingletonProductora(Pelicula peli, Video video, Clip clip) {
		this.peli = peli;
		this.video = video;
		this.clip = clip;
	}
	
	public static SingletonProductora getSingletonInstace(Pelicula peli, Video video, Clip clip) {
		if(singleton == null) {
			singleton = new SingletonProductora(peli,video,clip);
		}else {
			System.out.println("Ya se encuentran creados los objetos bajo esos atributos");
		}
	
		return singleton;
	}

	public Pelicula getPeli() {
		return peli;
	}

	public void setPeli(Pelicula peli) {
		this.peli = peli;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Clip getClip() {
		return clip;
	}

	public void setClip(Clip clip) {
		this.clip = clip;
	}

	public static SingletonProductora getSingleton() {
		return singleton;
	}

	public static void setSingleton(SingletonProductora singleton) {
		SingletonProductora.singleton = singleton;
	}
	
	

}
