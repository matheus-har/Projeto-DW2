package br.com.doa.facil.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.doa.facil.model.Companies;
import br.com.doa.facil.repository.CompaniesRepository;
import br.com.doa.facil.service.CompaniesService;

@RestController
@RequestMapping("/companies")
public class CompaniesResources {

	@Autowired
	private CompaniesRepository companiesRepository;

	@Autowired
	private CompaniesService companiesService;

	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_SEARCH_COMPANY') and #oauth2.hasScope('read')")
	public List<Companies> list(){
		return companiesRepository.findAll();
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_SEARCH_COMPANY') and #oauth2.hasScope('read')")
	public ResponseEntity<Companies> findById(@PathVariable Long id){
		Optional<Companies> companies = companiesRepository.findById(id);
		if(companies.isPresent()) {
			return ResponseEntity.ok(companies.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_REGISTER_COMPANY') and #oauth2.hasScope('write')")
	public Companies create(@Valid @RequestBody Companies companies) {
		return companiesService.save(companies);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_REMOVE_COMPANY') and #oauth2.hasScope('write')")
	public void delete(@PathVariable Long id) {
		companiesRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_REGISTER_COMPANY') and #oauth2.hasScope('write')")
	public ResponseEntity<Companies> update(@PathVariable Long id, @Valid @RequestBody Companies companies) {
		Companies companiesSaved = companiesService.update(id, companies);
		return ResponseEntity.ok(companiesSaved);
	}

}