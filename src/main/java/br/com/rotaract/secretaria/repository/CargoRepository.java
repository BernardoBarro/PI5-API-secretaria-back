package br.com.rotaract.secretaria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rotaract.secretaria.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long>{

	Optional<Cargo> findByNome(String descricao);

}
