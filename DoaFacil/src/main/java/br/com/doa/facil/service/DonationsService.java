package br.com.doa.facil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.doa.facil.model.Donations;
import br.com.doa.facil.model.Users;
import br.com.doa.facil.repository.DonationsRepository;
import br.com.doa.facil.repository.UsersRepository;
import br.com.doa.facil.service.exception.NonExistentOrInactiveUserException;

@Service
public class DonationsService {

	@Autowired
	private DonationsRepository donationsRepository;
	
	@Autowired
	private UsersRepository usersRepository;

	public Donations save(Donations donation) {
	    Users donor = usersRepository.findById(donation.getDonor().getId())
	        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doador não encontrado"));

	    if (!Boolean.TRUE.equals(donor.getActive())) {
	        throw new NonExistentOrInactiveUserException();
	    }

	    Users recipient = usersRepository.findById(donation.getRecipient().getId())
	        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipiente não encontrado"));

	    donation.setDonor(donor);
	    donation.setRecipient_Id(recipient);

	    return donationsRepository.save(donation);
	}


	public Donations update(Long id, Donations updatedDonation) {
	    Donations donationSaved = donationsRepository.findById(id)
	        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doação não encontrada"));

	    donationSaved.setDate(updatedDonation.getDate());
	    donationSaved.setProduct_Id(updatedDonation.getProduct_Id());
	    donationSaved.setPickup_Location(updatedDonation.getPickup_Location());
	    donationSaved.setActive(updatedDonation.getActive());

	    donationSaved.setDonor(updatedDonation.getDonor());
	    donationSaved.setRecipient_Id(updatedDonation.getRecipient());

	    return this.save(donationSaved);
	}


	public Donations findDonationById(Long id) {
	    return donationsRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
}