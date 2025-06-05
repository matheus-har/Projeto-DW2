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

import br.com.doa.facil.model.Products;
import br.com.doa.facil.repository.ProductsRepository;
import br.com.doa.facil.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsResources {

	@Autowired
	private ProductsRepository productsRepository;

	@Autowired
	private ProductsService productsService;

	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_REGISTER_PRODUCT') and #oauth2.hasScope('write')")
	public Products create(@Valid @RequestBody Products products) {
		return productsService.save(products);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_REMOVE_PRODUCT') and #oauth2.hasScope('write')")
	public void delete(@PathVariable Long id) {
		productsRepository.deleteById(id);
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_SEARCH_PRODUCT') and #oauth2.hasScope('read')")
	public ResponseEntity<Products> findById(@PathVariable Long id){
		Optional<Products> products = productsRepository.findById(id);
		if(products.isPresent()) {
			return ResponseEntity.ok(products.get());
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_SEARCH_PRODUCT') and #oauth2.hasScope('read')")
	public List<Products> list(){
		return productsRepository.findAll();
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_REGISTER_PRODUCT') and #oauth2.hasScope('write')")
	public ResponseEntity<Products> update(@PathVariable Long id, @Valid @RequestBody Products products) {
		Products productsSaved = productsService.update(id, products);
		return ResponseEntity.ok(productsSaved);
	}

}
