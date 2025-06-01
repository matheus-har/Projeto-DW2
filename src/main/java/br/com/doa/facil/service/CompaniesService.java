package br.com.doa.facil.service;

import org.springframework.beans.BeanUtils;
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

	public Companies update(Long id, Companies companie) {
		Companies companieSaved = companiesRepository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		BeanUtils.copyProperties(companie, companieSaved, "id");
		return companiesRepository.save(companieSaved);
	}

}
