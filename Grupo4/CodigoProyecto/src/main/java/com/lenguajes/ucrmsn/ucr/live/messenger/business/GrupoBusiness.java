package com.lenguajes.ucrmsn.ucr.live.messenger.business;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lenguajes.ucrmsn.ucr.live.messenger.data.GrupoData;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.HashEnviados;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Grupo;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Mensaje;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Rol;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Usuario;
import com.lenguajes.ucrmsn.ucr.live.messenger.excepciones.GrupoException;
import com.lenguajes.ucrmsn.ucr.live.messenger.excepciones.RolException;
import com.lenguajes.ucrmsn.ucr.live.messenger.excepciones.UsuarioException;

@Service
public class GrupoBusiness {

	private HashEnviados enlacesEnviados = HashEnviados.getInstancia();
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private GrupoData grupoData;

	public ArrayList<Grupo> listarGrupos() {

		return grupoData.listarGrupos();
	}

	public ArrayList<Usuario> usuariosPorGrupo(String idGrupo) {
		return grupoData.buscarUsuariosPorGrupo(idGrupo);

	}

	@Transactional
	public String crear(Usuario usuario) throws GrupoException, RolException, UsuarioException {

		String caracteres = "";
		String hash = "";
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			caracteres += (char) (random.nextInt(91) + 65);
		}

		hash = "/msn/" + DigestUtils.sha256Hex(caracteres);

		if (usuario == null)
			throw new UsuarioException("El usuario es requerido");
		if (usuario.getNombreUsuario() == null)
			throw new UsuarioException("El nombre de usuario es requerido");
		if (usuario.getListaRoles().isEmpty())
			throw new RolException("El rol es requerido");
		if (!usuario.getListaRoles().isEmpty()) {
			for (int i = 0; i < usuario.getListaRoles().size(); i++) {
				Rol rol = usuario.getListaRoles().get(i);
				if (rol.getNombre().equals("admin")) {
					/*
					 * grupoData.save(new Grupo(null, 0, 0, usuario, usuario));
					 */ }
			}
		}
		return hash;
	}

	@Transactional
	public void invitar(String to, String link) {

		/*
		 * Enlace enlace = new Enlace(link); enlacesEnviados.agregar(enlace);
		 * expirarEnlace(enlace);
		 */

		Calendar fecha = Calendar.getInstance();
		SimpleMailMessage mail = new SimpleMailMessage();

		mail.setFrom("ucrlivemessenger@gmail.com");
		mail.setTo(to);
		mail.setSubject("Invitación UCR Live Messenger");
		mail.setText("Bienvenido a UCR Live Messenger" + " \n" + "Utilice el link adjunto para comenzar a chatear."
				+ "\n" + "Expira en 3 minutos." + "\n" + "Hora del servidor: " + fecha.getTime()
				+ "localhost:8080/ucrmsn/interfazchat");

		javaMailSender.send(mail);
	}

	/*
	 * public void expirarEnlace(Enlace enlace) { try { Thread.sleep(180000); }
	 * catch (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } enlacesEnviados.eliminar(enlace); }
	 */
	@Transactional
	public void unirse(Usuario usuario, Grupo grupo) {
		grupo.getListaUsuarios().add(usuario);
		grupoData.update(grupo);
	}

	@Transactional
	public void actualizarMensajes(Usuario usuario) {

	}

	@Transactional
	public void actualizarMetricas(Usuario usuario) {

	}

	@Transactional
	public void guardarMensajes(Grupo grupo, Usuario usuario, Mensaje mensaje) {
		mensaje.setUsuario(usuario);
		mensaje.setGrupo(grupo);
		grupo.mandarMensaje(mensaje);
		grupo.setCantidadMensajes(grupo.getCantidadMensajes() + 1);
		grupoData.update(grupo);

	}

	@Transactional
	public int getVersion(Grupo grupo) {

		int version = grupo.getCantidadMensajes();
		version++;

		return version;
	}

	@Transactional
	public ArrayList<Mensaje> getMessagesFrom(int index) {
		return grupoData.buscarMensajes();
	}

	public boolean existeGrupo(int id) {
		ArrayList<Grupo> grupos = grupoData.listarGrupos();
		boolean contiene = false;
		for (int i = 0; i < grupos.size(); i++) {
			if (grupos.get(i).getId() == id) {
				contiene = true;
			}
		}
		return contiene;
	}

	public Grupo getGrupo(int id) {
		if (!existeGrupo(id)) {
			throw new GrupoException("El grupo no existe");
		} else {
			ArrayList<Grupo> grupos = grupoData.buscarGrupoPorId(id);
			Grupo grupo = new Grupo();
			for (int i = 0; i < grupos.size(); i++) {
				if (grupos.get(i).getId() == id) {
					grupo = grupos.get(i);
				}
			}
			return grupo;
		}
	}
}
