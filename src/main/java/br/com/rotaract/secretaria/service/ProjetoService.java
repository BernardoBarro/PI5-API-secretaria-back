package br.com.rotaract.secretaria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rotaract.secretaria.constant.StatusProjeto;
import br.com.rotaract.secretaria.dto.ProjetoDto;
import br.com.rotaract.secretaria.dto.ProjetoEditDto;
import br.com.rotaract.secretaria.model.Instituicao;
import br.com.rotaract.secretaria.model.Patrocinador;
import br.com.rotaract.secretaria.model.Projeto;
import br.com.rotaract.secretaria.repository.InstituicaoRepository;
import br.com.rotaract.secretaria.repository.PatrocinadorRepository;
import br.com.rotaract.secretaria.repository.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository projetoRepository;
	@Autowired
	private InstituicaoRepository instituicaoRepository;
	@Autowired
	private PatrocinadorRepository patrocinadorRepository;

	public Projeto criacaoProjeto(ProjetoDto projetoDto) {

		Projeto projeto = new Projeto();
		projeto.setNome(projetoDto.getNome());
		projeto.setDescricao(projetoDto.getDescricao());
		projeto.setDataInicio(projetoDto.getDataInicio());
		projeto.setDataFim(projetoDto.getDataFinal());
		projeto.setCategoria(projetoDto.getCategoria());
		projeto.setAreaEnfoque(projetoDto.getAreaEnfoque());
		projeto.setStatus(StatusProjeto.EM_PLANEJAMENTO);
		List<Patrocinador> patrocinadores = new ArrayList<>();
		if(Objects.nonNull(projetoDto.getPatrocinadores())) {
			projetoDto.getPatrocinadores().forEach(n -> {
				Patrocinador patrocinador = new Patrocinador();
				patrocinador.setNome(n.getNome());
				patrocinador.setDescricao(n.getDescricao());
				patrocinador.setValorDecimal(n.getValorDecimal());
				patrocinadorRepository.save(patrocinador);
				patrocinadores.add(patrocinador);
			});
		}
		List<Instituicao> instituicoes = new ArrayList<>();
		if(Objects.nonNull(projetoDto.getInstituicoes())) {
			projetoDto.getInstituicoes().forEach(n -> {
				Optional<Instituicao> optInstituicao = instituicaoRepository.findById(n.getId());
				instituicoes.add(optInstituicao.get());
			});
		}

		projeto.setPatrocinadores(patrocinadores);
		projeto.setInstituicoes(instituicoes);
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

		List<Patrocinador> patrocinadores = new ArrayList<>();
		if(Objects.nonNull(projetoEditDto.getPatrocinadores())) {
			projetoEditDto.getPatrocinadores().forEach(n -> {
				Optional<Patrocinador> optPatrocinador = patrocinadorRepository.findById(id);
				Patrocinador patrocinador = optPatrocinador.get();
				patrocinador.setNome(n.getNome());
				patrocinador.setDescricao(n.getDescricao());
				patrocinador.setValorDecimal(n.getValorDecimal());
				patrocinadorRepository.save(patrocinador);
				patrocinadores.add(patrocinador);
			});
		}
		
		projeto.setNome(projetoEditDto.getNome());
		projeto.setDescricao(projetoEditDto.getDescricao());
		projeto.setDataInicio(projetoEditDto.getDataInicio());
		projeto.setDataFim(projetoEditDto.getDataFinal());
		projeto.setCategoria(projetoEditDto.getCategoria());
		projeto.setAreaEnfoque(projetoEditDto.getAreaEnfoque());
		projeto.setStatus(projetoEditDto.getStatus());
		
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
