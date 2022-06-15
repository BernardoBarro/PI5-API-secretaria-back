package br.com.rotaract.secretaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rotaract.secretaria.model.Reuniao;

@Repository
public interface ReuniaoRepository extends JpaRepository<Reuniao, Long> {

}
