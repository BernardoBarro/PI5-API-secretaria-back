package br.com.rotaract.secretaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rotaract.secretaria.constant.StatusProjeto;
import br.com.rotaract.secretaria.dto.ProjetoDto;
import br.com.rotaract.secretaria.dto.ProjetoEditDto;
import br.com.rotaract.secretaria.model.Projeto;
import br.com.rotaract.secretaria.repository.ProjetoRepository;
import br.com.rotaract.secretaria.utils.BuildError;

@Service
public class ProjetoService {

	private final static String NOT_FOUND = "O projeto não existe";

	@Autowired
	private ProjetoRepository projetoRepository;

	public Projeto createProjeto(ProjetoDto projetoDto) {

		Projeto projeto = new Projeto();
		projeto.setNome(projetoDto.getNome());
		projeto.setDescricao(projetoDto.getDescricao());
		projeto.setDataInicio(projetoDto.getDataInicio());
		projeto.setStatus(StatusProjeto.EM_PLANEJAMENTO);
		projetoRepository.save(projeto);

		return projeto;
	}

	public List<Projeto> findProjetos() {
		
		return projetoRepository.findAll();
	}

	public Projeto findProjeto(Long ri) {
		
		Optional<Projeto> optProjeto = projetoRepository.findById(ri);
		BuildError.buildNotFoundException(optProjeto, NOT_FOUND);

		return optProjeto.get();
	}

	public Projeto updateProjeto(Long id, ProjetoEditDto projetoEditDto) {

		Optional<Projeto> optProjeto = projetoRepository.findById(id);
		BuildError.buildNotFoundException(optProjeto, NOT_FOUND);
		Projeto projeto = optProjeto.get();
		
		projeto.setNome(projetoEditDto.getNome());
		projeto.setDescricao(projetoEditDto.getDescricao());
		projeto.setDataInicio(projetoEditDto.getDataInicio());
		projeto.setStatus(projetoEditDto.getStatus());
		projetoRepository.save(projeto);
		
		return projeto;
	}
		
		public void deleteProjeto(Long id) {

			Optional<Projeto> optProjeto = projetoRepository.findById(id);
			BuildError.buildNotFoundException(optProjeto, NOT_FOUND);
			Projeto projeto = optProjeto.get();
			projeto.setStatus(StatusProjeto.CANCELADO);
			projetoRepository.save(projeto);
	}
}
