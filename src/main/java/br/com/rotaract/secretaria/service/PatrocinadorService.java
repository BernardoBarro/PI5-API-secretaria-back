package br.com.rotaract.secretaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rotaract.secretaria.dto.PatrocinadorDto;
import br.com.rotaract.secretaria.model.Patrocinador;
import br.com.rotaract.secretaria.repository.PatrocinadorRepository;
import br.com.rotaract.secretaria.utils.Validation;

@Service
public class PatrocinadorService {

	private final static String NOT_FOUND = "O patrocinador não existe";
	
	@Autowired
	private PatrocinadorRepository patrocinadorRepository;

	public Patrocinador createPatrocinador(PatrocinadorDto patrocinadorDto) {
		Patrocinador patrocinador = new Patrocinador();
		patrocinador.setValorDecimal(patrocinadorDto.getValorDecimal());
		patrocinador.setDescricao(patrocinadorDto.getDescricao());
		patrocinador.setNome(patrocinadorDto.getNome());

		patrocinadorRepository.save(patrocinador);

		return patrocinador;
	}

	public List<Patrocinador> findPatrocinadores() {
		
		return patrocinadorRepository.findAll();
	}

	public Patrocinador findPatrocinador(Long id) {
		
		Optional<Patrocinador> optPatrocinador = patrocinadorRepository.findById(id);
		Validation.validReturnObject(optPatrocinador, NOT_FOUND);

		return optPatrocinador.get();
	}
	
	public Patrocinador updatePatrocinador(Long id, PatrocinadorDto patrocinadorDto) {

		Optional<Patrocinador> optPatrocinador = patrocinadorRepository.findById(id);
		Validation.validReturnObject(optPatrocinador, NOT_FOUND);
		Patrocinador patrocinador = optPatrocinador.get();

		patrocinador.setValorDecimal(patrocinadorDto.getValorDecimal());
		patrocinador.setDescricao(patrocinadorDto.getDescricao());
		patrocinador.setNome(patrocinadorDto.getNome());
		

		patrocinadorRepository.save(patrocinador);

		return patrocinador;
	}
	
	public void deletePatrocinador(Long ri) {

		Optional<Patrocinador> optPatrocinador = patrocinadorRepository.findById(ri);
		Validation.validReturnObject(optPatrocinador, NOT_FOUND);
		patrocinadorRepository.delete(optPatrocinador.get());
	}
}