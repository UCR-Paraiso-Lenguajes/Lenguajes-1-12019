package com.dove.grupo1.msn.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional
public class CustomUserDetailService implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		/*
		if(username==null || username.trim().equals("")) throw new UsernameNotFoundException("El usuario no existe");
		
		User user = userData.findByEmail(username);
		
		if(user == null) throw new UsernameNotFoundException("El usuario no existe");
		
		Collection<? extends GrantedAuthority> roles = getAuthorities(user);
		
		//BCryptPasswordEncoder bcrytp = new BCryptPasswordEncoder();
		//String test = bcrytp.encode("123");
		
		return new org.springframework.security.core.userdetails.User(
				user.getEmail(), 
				user.getPassword(), 
				roles);*/
		return null;
	}

	private Collection<? extends GrantedAuthority> getAuthorities(Object user)//User user) 
	{
		/*String [] userRolesNames = 
				user.getRoles().
				stream().map(
						(role) -> role.getName()
				).
				toArray(String[]::new); 
				return AuthorityUtils.createAuthorityList(userRolesNames);
				*/ return null;
	}
}
