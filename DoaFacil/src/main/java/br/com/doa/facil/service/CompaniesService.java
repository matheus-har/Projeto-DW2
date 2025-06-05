package br.com.doa.facil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.doa.facil.model.Companies;
import br.com.doa.facil.repository.CompaniesRepository;

@Service
public class CompaniesService {

	@Autowired
	private CompaniesRepository companiesRepository;

	public Companies save(Companies companie) {
		return companiesRepository.save(companie); 
	}

	public Companies update(Long id, Companies updateCompanie) {
		Companies companieSaved = companiesRepository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException("Empresa não encontrada",1));
		
		companieSaved.setRegistered_Name(updateCompanie.getRegistered_Name());
		companieSaved.setFantasy_Name(updateCompanie.getFantasy_Name());
		companieSaved.setEmail(updateCompanie.getEmail());
		companieSaved.setTelephone(updateCompanie.getTelephone());
		companieSaved.setUser_Resp(updateCompanie.getUser_Resp());
		companieSaved.setActive(updateCompanie.getActive());

	    return this.save(companieSaved);
	}
	
	public Companies findDonationById(Long id) {
	    return companiesRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

}
