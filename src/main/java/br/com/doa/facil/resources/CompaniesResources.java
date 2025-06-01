package br.com.doa.facil.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import jakarta.validation.Valid;

@RestController
@RequestMapping("/companies")
public class CompaniesResources {

	@Autowired
	private CompaniesRepository companiesRepository;
	
	@Autowired
	private CompaniesRepository companiesService;
	
	@GetMapping
	public List<Companies> list(){
		return companiesRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Companies> findById(@PathVariable Long id){
		Optional<Companies> companies = companiesRepository.findById(id);
		if(companies.isPresent()) {
			return ResponseEntity.ok(companies.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public Companies create(@Valid @RequestBody Companies companies) {
		return companiesService.save(companies);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		companiesRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Companies> update(@PathVariable Long id, @Valid @RequestBody Companies companies) {
		Companies companiesSaved = companiesService.update(id, companies);
		return ResponseEntity.ok(companiesSaved);
	}
	
}