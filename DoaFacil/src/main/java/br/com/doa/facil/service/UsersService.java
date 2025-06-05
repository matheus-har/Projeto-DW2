package br.com.doa.facil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.doa.facil.model.Users;
import br.com.doa.facil.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;

	public Users save(Users user) {
		return usersRepository.save(user);
	}

	public Users update(Long id, Users updateUser) {
		Users usersSaved = usersRepository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException("Usuário não encontrado",1));
		
		usersSaved.setName(updateUser.getName());
		usersSaved.setEmail(updateUser.getEmail());
		usersSaved.setPassword(updateUser.getPassword());
		usersSaved.setBirthDate(updateUser.getBirthDate());
		usersSaved.setGender(updateUser.getGender());
		usersSaved.setTelephone(updateUser.getTelephone());
		usersSaved.setActive(updateUser.getActive());

	    return this.save(usersSaved);
	}
	
	public Users findDonationById(Long id) {
	    return usersRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

}
