package br.com.agmg.hroauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private BCryptPasswordEncoder passwordEnconder;
	
	private UserDetailsService userDetailService;
	
	public SecurityConfig(BCryptPasswordEncoder passwordEnconder, UserDetailsService userDetailService) {
		this.passwordEnconder = passwordEnconder;
		this.userDetailService = userDetailService;
	}

	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEnconder);
		
	}

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//	    http.authorizeRequests().antMatchers(HttpMethod.GET, "/users/search/**").permitAll();
//	}
	
}
