package br.com.agmg.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.agmg.hroauth.entities.User;
import br.com.agmg.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	private UserFeignClient userFeignClient;
	
	public UserService(UserFeignClient userFeignClient) {
		this.userFeignClient = userFeignClient;
	}
	
	public User findByEmail(String email) {
		User user =  userFeignClient.findByEmail(email).getBody();
		if (null == user) {
			logger.error("EMAIL NOT FOUND: " + email);
			throw new IllegalArgumentException("Email not found");
		}
		logger.info("EMAIL FOUND: " + email);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = null;
		try {
			user = this.findByEmail(username);
		} catch (Exception e) {
			throw new UsernameNotFoundException("Email not Found");
		}
		return  user;
	}
	
	
}
