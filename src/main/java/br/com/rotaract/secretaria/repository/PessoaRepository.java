package br.com.rotaract.secretaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.rotaract.secretaria.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
	@Query(value = "SELECT * FROM Pessoa P "
			+ "INNER JOIN Associado A ON A.id_pessoa = P.id_pessoa "
			+ "INNER JOIN Cargo C ON C.id_cargo = A.id_cargo "
			+ "WHERE C.id_cargo IN (1, 2, 3)", nativeQuery= true)
	public List<Pessoa> findByCargo ();

}
