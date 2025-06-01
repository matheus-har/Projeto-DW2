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

import br.com.doa.facil.model.Products;
import br.com.doa.facil.repository.ProductsRepository;
import br.com.doa.facil.service.ProductsService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductsResources {

	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private ProductsRepository produtyService;
	
	@GetMapping
	public List<Products> list(){
		return productsRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Products> findById(@PathVariable Long id){
		Optional<Products> products = productsRepository.findById(id);
		if(products.isPresent()) {
			return ResponseEntity.ok(products.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public Products create(@Valid @RequestBody Products products) {
		return produtyService.save(products);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		productsRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Products> update(@PathVariable Long id, @Valid @RequestBody Products products) {
		Products productsSaved = produtyService.update(id, products);
		ResponseEntity.ok(productsSaved);
	}
	
}
