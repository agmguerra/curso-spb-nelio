package br.com.agmg.hroauth.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private Set<Role> roles = new HashSet<>();
	
	public User() {
	}

	public User(Long id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<Role> getRoles() {
		return roles;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream().map(x -> new SimpleGrantedAuthority(x.getRoleName())).collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		//Caso exista uma regra para tratar esse caso. Deve ser
		//implementada aqui. Como nesse caso não existe. Retorna
		//sempre true
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		//Caso exista uma regra para tratar esse caso. Deve ser
		//implementada aqui. Como nesse caso não existe. Retorna
		//sempre true
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		//Caso exista uma regra para tratar esse caso. Deve ser
		//implementada aqui. Como nesse caso não existe. Retorna
		//sempre true
		return true;
	}

	@Override
	public boolean isEnabled() {
		//Caso exista uma regra para tratar esse caso. Deve ser
		//implementada aqui. Como nesse caso não existe. Retorna
		//sempre true
		return true;
	}
	
	
	
	

}
