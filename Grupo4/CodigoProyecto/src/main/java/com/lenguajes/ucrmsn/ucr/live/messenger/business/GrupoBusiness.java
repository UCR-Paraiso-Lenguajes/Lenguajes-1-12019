package com.lenguajes.ucrmsn.ucr.live.messenger.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lenguajes.ucrmsn.ucr.live.messenger.data.GrupoData;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Enlace;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Grupo;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Mensaje;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Rol;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Usuario;
import com.lenguajes.ucrmsn.ucr.live.messenger.excepciones.GrupoException;

@Service
public class GrupoBusiness {

	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private GrupoData grupoData;
	private static List<Enlace> enlacesEnviados = new ArrayList<>();

	@Transactional
	public String crear(Usuario usuario) throws GrupoException {

		String caracteres = "";
		String hash = "";
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			caracteres += (char) (random.nextInt(91) + 65);
		}
		
		hash = "/msn/"+DigestUtils.sha256Hex(caracteres);

		if (usuario == null)
			throw new RuntimeException("El usuario es requerido");
		if (usuario.getNombreUsuario() == null)
			throw new RuntimeException("El nombre de usuario es requerido");
		if (usuario.getListaRoles().isEmpty())
			throw new RuntimeException("El rol es requerido");
		if (!usuario.getListaRoles().isEmpty()) {
			for (int i = 0; i < usuario.getListaRoles().size(); i++) {
				Rol rol = usuario.getListaRoles().get(i);
				if (rol.getNombre().equals("admin")) {
					grupoData.save(new Grupo(0, null, 0, 0, usuario, usuario));
				}
			}
		}
		return hash;
	}

	public void invitar(String to, String link) {
		
		Enlace enlace = new Enlace(link);
		enlacesEnviados.add(enlace);
		
		SimpleMailMessage mail = new SimpleMailMessage();

		mail.setFrom("ucrlivemessenger@gmail.com");
		mail.setTo(to);
		mail.setSubject("Invitación a participar en el chat");
		mail.setText(link);

		javaMailSender.send(mail);	
	}
	
	@Transactional
	public void unirse(Usuario usuario, Grupo grupo) {
		grupo.getListaUsuarios().add(usuario);
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
	public int getVersion(Grupo grupo) {

		int version = grupo.getCantidadMensajes();
		version++;

		return version;
	}

	@Transactional
	public void getMessagesFrom(int index) {

	}
	
}
