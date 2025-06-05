package br.com.doa.facil.resources;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
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

import br.com.doa.facil.model.Users;
import br.com.doa.facil.repository.UsersRepository;
import br.com.doa.facil.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersResources {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private UsersService usersService;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_SEARCH_USERS') and #oauth2.hasScope('read')")
	public List<Users> list(){
		return usersRepository.findAll();
	}

	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_REGISTER_USERS') and #oauth2.hasScope('write')")
	public Users create(@Valid @RequestBody Users users, HttpServletResponse response) {
		return usersRepository.save(users);
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_SEARCH_USERS') and #oauth2.hasScope('read')")
	public ResponseEntity<Users> findById(@PathVariable Long id){
		Optional<Users> user = usersRepository.findById(id);
		if(user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_REMOVE_USERS') and #oauth2.hasScope('write')")
	public void delete(@PathVariable Long id) {
		usersRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_REGISTER_USERS') and #oauth2.hasScope('write')")
	public ResponseEntity<Users> update(@PathVariable Long id, @Valid @RequestBody Users user) {
		Users usersSaved = usersService.update(id, user);
		return ResponseEntity.ok(usersSaved);
	}
}

