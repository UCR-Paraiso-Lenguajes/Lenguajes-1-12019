package com.lenguajes.ucrmsn.ucr.live.messenger.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Grupo;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Mensaje;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Rol;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Usuario;
import com.lenguajes.ucrmsn.ucr.live.messenger.excepciones.GrupoException;

@Service
public class GrupoBusiness {

	@Autowired
    private JavaMailSender javaMailSender;
	
	@Transactional
	public List<Grupo> crear(Usuario usuario,Grupo grupo) throws GrupoException {	
		
		if (usuario == null) 
			throw new RuntimeException("El usuario es requerido");
		if (usuario.getNombreUsuario() == null) 
			throw new RuntimeException("El nombre de usuario es requerido");
		if (usuario.getListaRoles().isEmpty())
			throw new RuntimeException("El rol es requerido");
		if(!usuario.getListaRoles().isEmpty()) {
			for (int i = 0; i < usuario.getListaRoles().size(); i++) {
				Rol rol = usuario.getListaRoles().get(i);
				if (rol.getNombre().equals("admin"))
					grupo = new Grupo(0, "", 0, 0, usuario, usuario);
			}
		}
		return null;
	}
	
	public void invitar(String to, String link) {

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setFrom("ucrlivemessenger@gmail.com");
        mail.setTo(to);
        mail.setSubject("Invitación a participar en el chat");
        mail.setText(link);

        javaMailSender.send(mail);
    }
	
	@Transactional
	public void unirse(Usuario usuario) {
		
	}
	
	@Transactional
	public void actualizarMensajes(Usuario usuario) {
		
	}
	
	@Transactional
	public void actualizarMetricas(Usuario usuario) {
		
	}
	
	@Transactional
	public void guardarMensajes(Usuario usuario, Mensaje mensaje) {
		
	}
	
	@Transactional
	public int getVersion (Grupo grupo) {
		return 0;
	}
	
	@Transactional
	public void getMessagesFrom(int index) {

	}
	
}
