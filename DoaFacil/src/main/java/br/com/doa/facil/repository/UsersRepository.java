package br.com.doa.facil.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.doa.facil.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	
	public Optional<Users> findByEmail(String email);

}