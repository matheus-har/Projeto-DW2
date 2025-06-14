package br.com.doa.facil.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.doa.facil.model.Users;
import br.com.doa.facil.repository.UsersRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Users> userOptional = usersRepository.findByEmail(email);
		Users user = userOptional.orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha incorretos"));
		return new org.springframework.security.core.userdetails.User
				(email, user.getPassword(), getPermissions(user));
	}

	private Collection<? extends GrantedAuthority> getPermissions(Users users) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		users.getPermissions().forEach(p -> 
		authorities.add(
				new SimpleGrantedAuthority(p.getDescription().toUpperCase())));
		return authorities;
	}

}	