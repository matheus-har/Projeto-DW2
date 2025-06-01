package br.com.doa.facil.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.doa.facil.model.Products;
import br.com.doa.facil.repository.ProductsRepository;


@Service
public class ProductsService {
	
	@Autowired
	private ProductsRepository productsRepository;
	
	public Products save(Products product) 
	{
		return productsRepository.save(product);
	}
	
	public Products update(Long id, Products product) {
		Products productSaved = productsRepository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		BeanUtils.copyProperties(product, productSaved, "id");
		return productsRepository.save(productSaved);
	}
}
