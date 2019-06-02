package com.video.renting.domain;

public class SingletonProductora {
	
	private Pelicula peli;
	private Video video;
	private Clip clip;
	private static SingletonProductora singleton;
	
	public static SingletonProductora getSingletonInstace(Pelicula peli, Video video, Clip clip) {
		if(singleton == null) {
			singleton = new SingletonProductora(peli,video,clip);
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


}
