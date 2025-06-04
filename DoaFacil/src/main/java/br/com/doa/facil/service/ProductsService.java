package br.com.doa.facil.service;

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

	public Products update(Long id, Products updateProduct) {
		Products productSaved = productsRepository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException("Produto não encontrado",1));
		productSaved.setName(updateProduct.getName());
		productSaved.setAmount(updateProduct.getAmount());
		productSaved.setValidity(updateProduct.getValidity());
		productSaved.setType(updateProduct.getType());
		productSaved.setConservation(updateProduct.getConservation());
		productSaved.setSize(updateProduct.getSize());
		productSaved.setActive(updateProduct.getActive());

	    return this.save(productSaved);
	}
	
	public Products findDonationById(Long id) {
	    return productsRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
}
