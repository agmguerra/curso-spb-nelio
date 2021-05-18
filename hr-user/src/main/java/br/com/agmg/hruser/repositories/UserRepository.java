package br.com.agmg.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agmg.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	
}
