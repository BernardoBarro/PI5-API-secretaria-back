package br.com.rotaract.secretaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.rotaract.secretaria.dto.ConvidadoDto;
import br.com.rotaract.secretaria.model.Convidado;
import br.com.rotaract.secretaria.repository.ConvidadoRepository;
import br.com.rotaract.secretaria.utils.BuildError;

@Service
public class ConvidadoService {

	private final static String NOT_FOUND = "O convidado não existe";
	
	@Autowired
	private ConvidadoRepository convidadoRepository;
	
	public Convidado createConvidado(ConvidadoDto convidadoDto) {
		Convidado convidado = new Convidado();
		convidado.setNome(convidadoDto.getNome());
		convidado.setContato(convidadoDto.getContato());
		
		convidadoRepository.save(convidado);

		return convidado;
	}
	
	public List<Convidado> findConvidados() {
		
		return convidadoRepository.findAll();
	}

	public Convidado findConvidado(Long id) {
		
		Optional<Convidado> optConvidado = convidadoRepository.findById(id);
		BuildError.buildNotFoundException(optConvidado, NOT_FOUND);

		return optConvidado.get();
	}
	
	public Convidado updateConvidado(Long id, ConvidadoDto convidadoDto) {

		Optional<Convidado> optConvidado = convidadoRepository.findById(id);
		BuildError.buildNotFoundException(optConvidado, NOT_FOUND);
		Convidado convidado = optConvidado.get();
		convidado.setNome(convidadoDto.getNome());
		convidado.setContato(convidadoDto.getContato());

		convidadoRepository.save(convidado);

		return convidado;
	}
	
	public void deleteConvidado(Long id) {

		Optional<Convidado> optConvidado = convidadoRepository.findById(id);
		BuildError.buildNotFoundException(optConvidado, NOT_FOUND);
		convidadoRepository.delete(optConvidado.get());
	}
}
