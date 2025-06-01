package br.com.doa.facil.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.doa.facil.repository.DonationsRepository;
import br.com.doa.facil.repository.UsersRepository;
import br.com.doa.facil.service.exception.NonExistentOrInactiveUserException;
import br.com.doa.facil.model.Donations;
import br.com.doa.facil.model.Users;

@Service
public class DonationsService {
	
	@Autowired
	private DonationsRepository donationsRepository;
	private UsersRepository usersRepository;
	
	public Donations save(Donations donation, Users user) {
	    Optional<Users> userOptional = usersRepository.findById(user.getId());
	    if (!userOptional.isPresent() || !userOptional.get().getActive()) 
	    {
	        throw new NonExistentOrInactiveUserException();
	    }
	    return donationsRepository.save(donation);
	}

	public Donations update(Long id, Donations donations) {
	    Optional<Donations> donation = donationsRepository.findById(id);
	    if (!donation.isPresent()) {
	        throw new NonExistentOrInactiveUserException();
	    }

	    Donations donationSaved = findDonationById(id);
	    BeanUtils.copyProperties(donations, donationSaved, "id");
	    return donationsRepository.save(donationSaved);
	}
	
	public Donations findDonationById(Long id) {
	    return donationsRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
}
