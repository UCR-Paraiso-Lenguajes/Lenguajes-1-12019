package com.chat.bussines;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.data.RolData;
import com.chat.domain.Rol;

@Service
public class RolBussines {

	@Autowired
	private RolData roldata;
	
	
	public void agregarRol(Rol rol)  {
		if(rol != null) {
			roldata.addRol(rol);
		} throw new RuntimeException("El rol es requerido");
	}
	
}
