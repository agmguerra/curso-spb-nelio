package br.com.agmg.hroauth.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.agmg.hroauth.entities.User;
import br.com.agmg.hroauth.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	private UserService userService;
	
	public UserResource(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		try {
			User user = userService.findByEmail(email);
			return ResponseEntity.ok(user);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.noContent().build();
		}
	}
	
}
