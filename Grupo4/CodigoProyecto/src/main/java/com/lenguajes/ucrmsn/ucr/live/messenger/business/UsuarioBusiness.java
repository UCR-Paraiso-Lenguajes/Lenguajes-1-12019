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

import com.lenguajes.ucrmsn.ucr.live.messenger.domain.HashEnviados;
import com.lenguajes.ucrmsn.ucr.live.messenger.data.UsuarioData;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Grupo;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Rol;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Usuario;
import com.lenguajes.ucrmsn.ucr.live.messenger.excepciones.RolException;
import com.lenguajes.ucrmsn.ucr.live.messenger.excepciones.UsuarioException;

@Service
public class UsuarioBusiness {
	
	List<String> listaNombres=new ArrayList<String>();
	List<String> listaAvatar=new ArrayList<String>();
	
	private HashEnviados enlacesEnviados=HashEnviados.getInstancia();
	
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private UsuarioData usuariodata;
	
	public UsuarioBusiness() {
		listaNombres = new ArrayList<>();
		listaAvatar = new ArrayList<>();

		listaNombres.add("inmanish");
		listaNombres.add("nflector");
		listaNombres.add("malegety");
		listaNombres.add("facoiles");
		listaNombres.add("rvaloper");
		listaNombres.add("umbeakid");
		listaNombres.add("tombleth");
		listaNombres.add("papholot");
		listaNombres.add("lesmudom");
		listaNombres.add("antemest");
		
		listaNombres.add("tioniuma");
		listaNombres.add("cisiande");
		listaNombres.add("monvefte");
		listaNombres.add("gouseamb");
		listaNombres.add("fujigyna");
		listaNombres.add("acksequi");
		listaNombres.add("atinghte");
		listaNombres.add("lingtort");
		listaNombres.add("idaverag");
		listaNombres.add("phtepoli");
		
		listaNombres.add("pasanctu");
		listaNombres.add("airiandr");
		listaNombres.add("phlovery");
		listaNombres.add("lausilia");
		listaNombres.add("oucrempa");
		listaNombres.add("undently");
		listaNombres.add("promparm");
		listaNombres.add("ndsoldia");
		listaNombres.add("lentheim");
		listaNombres.add("oxforthe");
		
		listaNombres.add("zoadozov");
		listaNombres.add("trineand");
		listaNombres.add("oreditch");
		listaNombres.add("iaticiel");
		listaNombres.add("quateabl");
		listaNombres.add("entaderi");
		listaNombres.add("amanchor");
		listaNombres.add("abrackla");
		listaNombres.add("jacrepid");
		listaNombres.add("huleastr");
		
		listaNombres.add("ombletri");
		listaNombres.add("posystri");
		listaNombres.add("ioneratr");
		listaNombres.add("iculside");
		listaNombres.add("rayrolsi");
		listaNombres.add("craterva");
		listaNombres.add("ibisions");
		listaNombres.add("utsuchei");
		listaNombres.add("dayoving");
		listaNombres.add("poiselis");
	
		listaAvatar.add("IMG/avatar1.png");
		listaAvatar.add("IMG/avatar2.png");
		listaAvatar.add("IMG/avatar3.png");
		listaAvatar.add("IMG/avatar4.png");
		listaAvatar.add("IMG/avatar5.png");
		listaAvatar.add("IMG/avatar6.png");
		listaAvatar.add("IMG/avatar7.png");
		listaAvatar.add("IMG/avatar8.png");
		listaAvatar.add("IMG/avatar9.png");
		listaAvatar.add("IMG/avatar10.png");
		 
		listaAvatar.add("IMG/avatar11.png");
		listaAvatar.add("IMG/avatar12.png");
		listaAvatar.add("IMG/avatar13.png");
		listaAvatar.add("IMG/avatar14.png");
		listaAvatar.add("IMG/avatar15.png");
		listaAvatar.add("IMG/avatar16.png");
		listaAvatar.add("IMG/avatar17.png");
		listaAvatar.add("IMG/avatar18.png");
		listaAvatar.add("IMG/avatar19.png");
		listaAvatar.add("IMG/avatar20.png");
		
		listaAvatar.add("IMG/avatar21.png");
		listaAvatar.add("IMG/avatar22.png");
		listaAvatar.add("IMG/avatar23.png");
		listaAvatar.add("IMG/avatar24.png");
		listaAvatar.add("IMG/avatar25.png");
		listaAvatar.add("IMG/avatar26.png");
		listaAvatar.add("IMG/avatar27.png");
		listaAvatar.add("IMG/avatar28.png");
		listaAvatar.add("IMG/avatar29.png");
		listaAvatar.add("IMG/avatar30.png");
		
		listaAvatar.add("IMG/avatar31.png");
		listaAvatar.add("IMG/avatar32.png");
		listaAvatar.add("IMG/avatar33.png");
		listaAvatar.add("IMG/avatar34.png");
		listaAvatar.add("IMG/avatar35.png");
		listaAvatar.add("IMG/avatar36.png");
		listaAvatar.add("IMG/avatar37.png");
		listaAvatar.add("IMG/avatar38.png");
		listaAvatar.add("IMG/avatar39.png");
		listaAvatar.add("IMG/avatar40.png");
		
		listaAvatar.add("IMG/avatar41.png");
		listaAvatar.add("IMG/avatar42.png");
		listaAvatar.add("IMG/avatar43.png");
		listaAvatar.add("IMG/avatar44.png");
		listaAvatar.add("IMG/avatar45.png");
		listaAvatar.add("IMG/avatar46.png");
		listaAvatar.add("IMG/avatar47.png");
		listaAvatar.add("IMG/avatar48.png");
		listaAvatar.add("IMG/avatar49.png");
		listaAvatar.add("IMG/avatar50.png");
	}

	@Transactional
	public Usuario asignarNombreYAvatarUsuarioGrupo(Usuario usuario, Grupo grupo) {
		int nombreRandom =  (int) (Math.random()*49+0);
		String nombreAleatorio = listaNombres.get(nombreRandom);
		
		int avatarRandom =(int) (Math.random()*49+0);
		String avatarAleatorio = listaAvatar.get(avatarRandom);
		
		for (int numUsuario = 0; numUsuario < grupo.getListaUsuarios().size(); numUsuario++) {
			Usuario us = grupo.getListaUsuarios().get(numUsuario);
			if (!nombreAleatorio.equals(us.getNombreUsuario())) {
				usuario.setNombreUsuario(nombreAleatorio);
			}
			
			if (!avatarAleatorio.equals(us.getAvatar())) {
				usuario.setAvatar(avatarAleatorio);
			}
		}
		return usuario;
	}
	@Transactional
	public Usuario asignarNombreYAvatar(Usuario usuario) {//un nuevo usuario sin grupo
		int nombreRandom =  (int) (Math.random()*49+0);
		String nombreAleatorio = listaNombres.get(nombreRandom);		
		
		int avatarRandom =(int) (Math.random()*49+0);
		String avatarAleatorio = listaAvatar.get(avatarRandom);
			
		usuario.setAvatar(avatarAleatorio);
		usuario.setNombreUsuario(nombreAleatorio);
	
		
		return usuario;
	}
	@Transactional
	public void invitar(String to) {
		String hash=crearHash(to);
		String link="localhost:8080/ucrmsn/interfazchat?hash="+hash;
		
		enlacesEnviados.agregar(hash);
		
		  expirarEnlace(hash);
		 		
		Calendar fecha = Calendar.getInstance();
		SimpleMailMessage mail = new SimpleMailMessage();

		mail.setFrom("ucrlivemessenger@gmail.com");
		mail.setTo(to);
		mail.setSubject("Invitación UCR Live Messenger");
		mail.setText("Bienvenido a UCR Live Messenger" 
				+ " \n" 
				+ "Utilice el link adjunto para comenzar a chatear."
				+ "\n" 
				+ "Expira en 3 minutos."
				+ "\n"
				+ "Hora del servidor: "
				+ fecha.getTime()
				+ "\n"
				+link);

		javaMailSender.send(mail);	
	}
	public void expirarEnlace(String hash) {

        	   Runnable task = new Runnable() {
                   public void run() {
                	   try {
						Thread.sleep(180000);
						enlacesEnviados.eliminar(hash);
					} catch (InterruptedException e) {
						throw new UsuarioException("no se pudo eliminar el hash");
					}
           	      ;}
                };
        	new Thread(task).start();
        	
		
        }
	public String crearHash(String correo) {
		String hash = DigestUtils.sha256Hex(correo);
		return hash;
	}
	@Transactional
	public void save(Usuario usuario) {
		if (usuario==null ) {
			throw new UsuarioException("el usuario esta vacio");
		}else if (usuario.getHash()==null ) {
			throw new UsuarioException("el hash no puede estar vacio");
		}
		usuariodata.save(usuario);
	}
}
