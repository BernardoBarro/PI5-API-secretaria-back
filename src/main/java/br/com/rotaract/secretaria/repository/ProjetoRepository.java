package br.com.rotaract.secretaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rotaract.secretaria.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long>{

}
