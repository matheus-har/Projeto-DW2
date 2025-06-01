package br.com.doa.facil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.doa.facil.model.Donations;

public interface DonationsRepository extends JpaRepository<Donations ,Long>{

}
