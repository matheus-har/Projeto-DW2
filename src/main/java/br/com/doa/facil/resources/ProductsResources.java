package br.com.doa.facil.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // <- aqui já importa tudo
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

    // Criar produto
    @PostMapping
    // @PreAuthorize(...) // remova para testar
    public Products create(@Valid @RequestBody Products products) {
        return productsService.save(products);
    }

    // Deletar produto
    @DeleteMapping("/{id}")
    // @PreAuthorize(...)
    public void delete(@PathVariable Long id) {
        productsRepository.deleteById(id);
    }

    // Buscar produto por ID
    @GetMapping("/{id}")
    // @PreAuthorize(...)
    public ResponseEntity<Products> findById(@PathVariable Long id) {
        Optional<Products> products = productsRepository.findById(id);
        return products.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ LISTAR produtos — ESTE é o endpoint que o Angular chama
    @GetMapping
    public List<Products> list() {
        return productsRepository.findAll();
    }

    // Atualizar produto
    @PutMapping("/{id}")
    // @PreAuthorize(...)
    public ResponseEntity<Products> update(@PathVariable Long id, @Valid @RequestBody Products products) {
        Products updated = productsService.update(id, products);
        return ResponseEntity.ok(updated);
    }
}
