package br.com.doa.facil.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.doa.facil.model.Companies;
import br.com.doa.facil.model.Users;
import br.com.doa.facil.repository.CompaniesRepository;
import br.com.doa.facil.repository.UsersRepository;

@Service
public class CompaniesService {
	
	@Autowired
	private CompaniesRepository companiesRepository;
	
	public Companies save(Companies companie) 
	{
		return companiesRepository.save(companie);
	}

	public Companies update(Long id, Companies companies) {
		Optional<Companies> companie = companiesRepository.findById(companies.getId());
		if(!companie.isPresent() || !companie.get().getActive()) {
			throw new NonExistentOrInactiveUserException();
		}

		Companies companiesSaved = findCompaniesById(id);
		BeanUtils.copyProperties(companies, companiesSaved, "id");
		return companiesRepository.save(companiesSaved);
	}
	
	public Companies findCompaniesById(Long id) {
		Companies companiesSaved = companiesRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return companiesSaved;
	}
}
