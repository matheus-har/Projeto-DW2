package br.com.doa.facil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompaniesService {
	
	@Autowired
	private 
	
	@Autowired
	private 
	
	public  save() {
		Optional<>  = .findById(.getUser().getId());
		if(!.isPresent() || !.get().getActive()) {
			throw new NonExistentOrInactiveUserException();
		}
		return activityRepository.save();
	}

	public  update(Long id, ) {
		Optional<>  = .findById(.getUser().getId());
		if(!.isPresent() || !.get().getActive()) {
			throw new NonExistentOrInactiveUserException();
		}

		 = (id);
		BeanUtils.copyProperties(activity, activitySaved, "id");
		return activityRepository.save(activitySaved);
	}
	
	public (Long id) {
		 = .findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return ;
	}
}
