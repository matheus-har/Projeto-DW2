package br.com.doa.facil.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.doa.facil.model.Companies;
import br.com.doa.facil.model.Products;
import br.com.doa.facil.repository.ProductsRepository;


@Service
public class ProductsService {
	
	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private 
	
	public Products save(Products product) 
	{
		return productsRepository.save(product);
	}

	public Products update(Long id, Products products) {
		Optional<Products> product = productsRepository.findById(products.getId());
		if(!product.isPresent() || !product.get().getActive()) {
			throw new NonExistentOrInactiveUserException();
		}

		Products productsSaved = findProductsById(id);
		BeanUtils.copyProperties(products, productsSaved, "id");
		return productsRepository.save(productsSaved);
	}
	
	public Products findProductsById(Long id) {
		Products productsSaved = productsRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return productsSaved;
	}
}
