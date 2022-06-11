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

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository projetoRepository;

	public Projeto criacaoProjeto(ProjetoDto projetoDto) {

		Projeto projeto = new Projeto();
		projeto.setNome(projetoDto.getNome());
		projeto.setDescricao(projetoDto.getDescricao());
		projeto.setDataInicio(projetoDto.getDataInicio());
		projeto.setStatus(StatusProjeto.EM_PLANEJAMENTO);
		projetoRepository.save(projeto);

		return projeto;
	}

	public List<Projeto> buscaProjetos() {
		
		List<Projeto> projetos = projetoRepository.findAll();		
		
		return projetos;
	}

	public Projeto buscaProjeto(Long ri) {
		
		Optional<Projeto> projeto = projetoRepository.findById(ri);

		return projeto.get();
	}

	public Projeto atualizaProjeto(Long id, ProjetoEditDto projetoEditDto) {

		Optional<Projeto> optProjeto = projetoRepository.findById(id);
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
			if(optProjeto.isPresent()) {
				Projeto projeto = optProjeto.get();
				projeto.setStatus(StatusProjeto.CANCELADO);
				projetoRepository.save(projeto);
		}
	}
}
