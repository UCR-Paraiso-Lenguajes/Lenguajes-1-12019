package com.lenguajes.ucrmsn.ucr.live.messenger.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Grupo;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Usuario;

@Service
public class UsuarioBusiness {
	
	List<String> listaNombres;
	List<String> listaAvatar;
	
	@Transactional
	public void llenarLista() {
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
	
		listaAvatar.add("/img/avatar1.png");
		listaAvatar.add("/img/avatar2.png");
		listaAvatar.add("/img/avatar3.png");
		listaAvatar.add("/img/avatar4.png");
		listaAvatar.add("/img/avatar5.png");
		listaAvatar.add("/img/avatar6.png");
		listaAvatar.add("/img/avatar7.png");
		listaAvatar.add("/img/avatar8.png");
		listaAvatar.add("/img/avatar9.png");
		listaAvatar.add("/img/avatar10.png");
		 
		listaAvatar.add("/img/avatar11.png");
		listaAvatar.add("/img/avatar12.png");
		listaAvatar.add("/img/avatar13.png");
		listaAvatar.add("/img/avatar14.png");
		listaAvatar.add("/img/avatar15.png");
		listaAvatar.add("/img/avatar16.png");
		listaAvatar.add("/img/avatar17.png");
		listaAvatar.add("/img/avatar18.png");
		listaAvatar.add("/img/avatar19.png");
		listaAvatar.add("/img/avatar20.png");
		
		listaAvatar.add("/img/avatar21.png");
		listaAvatar.add("/img/avatar22.png");
		listaAvatar.add("/img/avatar23.png");
		listaAvatar.add("/img/avatar24.png");
		listaAvatar.add("/img/avatar25.png");
		listaAvatar.add("/img/avatar26.png");
		listaAvatar.add("/img/avatar27.png");
		listaAvatar.add("/img/avatar28.png");
		listaAvatar.add("/img/avatar29.png");
		listaAvatar.add("/img/avatar30.png");
		
		listaAvatar.add("/img/avatar31.png");
		listaAvatar.add("/img/avatar32.png");
		listaAvatar.add("/img/avatar33.png");
		listaAvatar.add("/img/avatar34.png");
		listaAvatar.add("/img/avatar35.png");
		listaAvatar.add("/img/avatar36.png");
		listaAvatar.add("/img/avatar37.png");
		listaAvatar.add("/img/avatar38.png");
		listaAvatar.add("/img/avatar39.png");
		listaAvatar.add("/img/avatar40.png");
		
		listaAvatar.add("/img/avatar41.png");
		listaAvatar.add("/img/avatar42.png");
		listaAvatar.add("/img/avatar43.png");
		listaAvatar.add("/img/avatar44.png");
		listaAvatar.add("/img/avatar45.png");
		listaAvatar.add("/img/avatar46.png");
		listaAvatar.add("/img/avatar47.png");
		listaAvatar.add("/img/avatar48.png");
		listaAvatar.add("/img/avatar49.png");
		listaAvatar.add("/img/avatar50.png");
	}

	@Transactional
	public void asignarNombreYAvatar(Usuario usuario, Grupo grupo) {
		Random nombreRandom = new Random();
		String nombreAleatorio = listaNombres.get(nombreRandom.nextInt(listaNombres.size()));
		
		Random avatarRandom = new Random();
		String avatarAleatorio = listaAvatar.get(avatarRandom.nextInt(listaAvatar.size()));
		
		for (int numUsuario = 0; numUsuario < grupo.getListaUsuarios().size(); numUsuario++) {
			Usuario us = grupo.getListaUsuarios().get(numUsuario);
			if (!nombreAleatorio.equals(us.getNombreUsuario())) {
				usuario.setNombreUsuario(nombreAleatorio);
			}
			
			if (!avatarAleatorio.equals(us.getAvatar())) {
				usuario.setAvatar(avatarAleatorio);
			}
		}
	}
}
