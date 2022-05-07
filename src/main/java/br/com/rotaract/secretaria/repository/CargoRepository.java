package br.com.rotaract.secretaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rotaract.secretaria.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long>{

	Cargo findByNome(String descricao);

}
