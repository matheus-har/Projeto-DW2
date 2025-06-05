package br.com.doa.facil.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import br.com.doa.facil.model.Donations;
import br.com.doa.facil.repository.DonationsRepository;
import br.com.doa.facil.service.DonationsService;

@RestController
@RequestMapping("/donations")
public class DonationsResources {

	@Autowired
	private DonationsRepository donationsRepository;

	@Autowired
	private DonationsService donationsService;

	@GetMapping
	public List<Donations> list(){
		return donationsRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Donations> findById(@PathVariable Long id){
		Optional<Donations> donations = donationsRepository.findById(id);
		if(donations.isPresent()) {
			return ResponseEntity.ok(donations.get());
		}
		return ResponseEntity.notFound().build();

	}

	@PostMapping
	public Donations create(@Valid @RequestBody Donations donations) {
		return donationsRepository.save(donations);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		donationsRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Donations> update(@PathVariable Long id, @Valid @RequestBody Donations donations) {
		Donations donationsSaved = donationsService.update(id, donations);
		return ResponseEntity.ok(donationsSaved);
	}

}
