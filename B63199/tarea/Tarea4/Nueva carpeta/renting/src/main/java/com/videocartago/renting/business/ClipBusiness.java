package com.videocartago.renting.business;

import java.awt.dnd.InvalidDnDOperationException;

import org.springframework.beans.factory.annotation.Autowired;

import com.videocartago.renting.data.ClipData;
import com.videocartago.renting.data.VideoData;
import com.videocartago.renting.domain.Clip;
import com.videocartago.renting.domain.Video;

public class ClipBusiness {

	@Autowired
	ClipData clip;
	
	public Clip guardarClip(Clip film) {
		if(film!=null)
		throw new InvalidDnDOperationException("No hay clip para insertar, o está incompleto");
		return clip.save(film);
	}
	
}
