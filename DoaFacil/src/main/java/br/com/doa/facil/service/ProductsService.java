package br.com.doa.facil.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.doa.facil.repository.ProductsRepository;


@Service
public class ProductsService {
	
	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private 
	
	public Products save() {
		Optional<>  = .findById(.getUser().getId());
		if(!.isPresent() || !.get().getActive()) {
			throw new NonExistentOrInactiveUserException();
		}
		return activityRepository.save();
	}

	public Products update(Long id, ) {
		Optional<>  = .findById(.getUser().getId());
		if(!.isPresent() || !.get().getActive()) {
			throw new NonExistentOrInactiveUserException();
		}

		Products = (id);
		BeanUtils.copyProperties(activity, activitySaved, "id");
		return activityRepository.save(activitySaved);
	}
	
	public Products findProductsById(Long id) {
		Products productsSaved = .findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return ;
	}
}
