package br.com.rotaract.secretaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.rotaract.secretaria.dto.ConvidadoDto;
import br.com.rotaract.secretaria.model.Convidado;
import br.com.rotaract.secretaria.repository.ConvidadoRepository;

@Service
public class ConvidadoService {

	
	@Autowired
	private ConvidadoRepository convidadoRepository;
	
	public Convidado createConvidado(ConvidadoDto convidadoDto) {
		Convidado convidado = new Convidado();
		convidado.setNome(convidadoDto.getNome());
		convidado.setContato(convidadoDto.getContato());
		
		convidadoRepository.save(convidado);

		return convidado;
	}
	
	
	public List<Convidado> findConvidado() {
		
		List<Convidado> convidado = convidadoRepository.findAll();		
		
		return convidado;
	}

	public Convidado findConvidado(Long ri) {
		
		Optional<Convidado> convidado = convidadoRepository.findById(ri);

		return convidado.get();
	}
	
	
	public Convidado updateConvidado(Long ri, ConvidadoDto convidadoDto) {

		Optional<Convidado> optConvidado = convidadoRepository.findById(ri);
		Convidado convidado = optConvidado.get();
		convidado.setNome(convidadoDto.getNome());
		convidado.setContato(convidadoDto.getContato());

		convidadoRepository.save(convidado);

		return convidado;
	}

}


