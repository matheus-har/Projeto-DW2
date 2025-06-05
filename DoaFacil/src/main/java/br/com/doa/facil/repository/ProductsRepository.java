package br.com.doa.facil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.doa.facil.model.Products;

public interface ProductsRepository extends JpaRepository<Products ,Long>{

}
