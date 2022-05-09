package br.com.rotaract.secretaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rotaract.secretaria.dto.PatrocinadorDto;
import br.com.rotaract.secretaria.model.Patrocinador;
import br.com.rotaract.secretaria.repository.PatrocinadorRepository;

@Service
public class PatrocinadorService {

	@Autowired
	private PatrocinadorRepository patrocinadorRepository;

	public Patrocinador createPatrocinador(PatrocinadorDto patrocinadorDto) {
		Patrocinador patrocinador = new Patrocinador();
		patrocinador.setNome(patrocinadorDto.getNome());
		patrocinador.setContato(patrocinadorDto.getContato());

		patrocinadorRepository.save(patrocinador);

		return patrocinador;
	}
}