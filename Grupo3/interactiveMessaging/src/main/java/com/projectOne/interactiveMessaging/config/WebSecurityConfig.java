package com.projectOne.interactiveMessaging.config;
/*
import javax.sql.DataSource;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true, proxyTargetClass=true)

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	@Autowired
	private UserDetailsService customerDetailsService;
	@Autowired
	private DataSource datasource;
	
	@Bean
	public  PasswordEncoder  passwordEncoder() 
	{
		return encoder;
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(customerDetailsService)
		.passwordEncoder(passwordEncoder());
		
	}

	@Override
	protected void  configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable().
		headers().
			frameOptions().sameOrigin()
				.and()
			.authorizeRequests() 
				.antMatchers("/insertarPelicula").hasRole("ADMIN")
				.antMatchers("/findMovies").hasRole("ADMIN")
				.antMatchers("/api/***").permitAll()
				.anyRequest().authenticated()
				.and().
			formLogin().loginPage("/login")
				.defaultSuccessUrl("/home")
				.failureUrl("/login?error")
				.permitAll()
				.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout")
				.permitAll()
				.and()
				.exceptionHandling()
				.accessDeniedPage("/accessDenied");		
	}

}
	*/

