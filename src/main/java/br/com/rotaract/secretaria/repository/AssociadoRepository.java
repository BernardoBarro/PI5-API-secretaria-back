package br.com.rotaract.secretaria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rotaract.secretaria.model.Associado;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long>{
	
	Optional<Associado> findByEmail(String email);

	Associado getByEmail(String username);

}
