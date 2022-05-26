package br.com.rotaract.secretaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.rotaract.secretaria.dto.PessoaCargo;
import br.com.rotaract.secretaria.model.Associado;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long>{
	
	@Query("SELECT P.nome, C.nome FROM Pessoa P INNER JOIN Associado A ON A.pessoa = P.id  "
			+ "INNER JOIN Cargo C ON C.id = A.cargo "
			+ "WHERE C.nome in ('Secretário', 'Vice-Presidente', 'Presidente') ")
	public List<PessoaCargo> findByCargo ();

}
