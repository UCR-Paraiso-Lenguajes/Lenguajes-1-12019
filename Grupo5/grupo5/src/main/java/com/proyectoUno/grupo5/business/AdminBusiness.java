package com.proyectoUno.grupo5.business;

import org.springframework.stereotype.Service;

import com.proyectoUno.grupo5.domain.Admin;

@Service
public class AdminBusiness {
	
	public boolean validacion(String username, String password) {
		
		Admin admin= new Admin();
		if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
			return true;
		}else {
			return false;
		}
		
	
		
		
	}
	
}
