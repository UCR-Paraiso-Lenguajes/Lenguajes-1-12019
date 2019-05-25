package com.videocartago.renting.business;

import java.awt.dnd.InvalidDnDOperationException;

import org.springframework.beans.factory.annotation.Autowired;

import com.videocartago.renting.data.VideoData;
import com.videocartago.renting.domain.Video;

public class VideoBusiness {

	@Autowired
	VideoData videoData;
	
	
	public Video guardarVideo(Video film) {
		if(film!=null)
		throw new InvalidDnDOperationException("No hay video para insertar, o está incompleto");
		return videoData.save(film);
	}
	
}
