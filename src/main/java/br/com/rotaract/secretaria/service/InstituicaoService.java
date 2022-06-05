package br.com.rotaract.secretaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rotaract.secretaria.dto.InstituicaoDto;
import br.com.rotaract.secretaria.model.Instituicao;
import br.com.rotaract.secretaria.repository.InstituicaoRepository;

@Service
public class InstituicaoService {

	
	@Autowired
	private InstituicaoRepository instituicaoRepository;
	
	public Instituicao createInstituicao(InstituicaoDto instituicaoDto) {
		Instituicao instituicao = new Instituicao();
		instituicao.setNome(instituicaoDto.getNome());
		instituicao.setContato(instituicaoDto.getContato());
		instituicao.setDetalhes(instituicaoDto.getDetalhes());
		
		instituicaoRepository.save(instituicao);

		return instituicao;
	}
	
	
	public List<Instituicao> findInstituicao() {
		
		List<Instituicao> instituicoes = instituicaoRepository.findAll();		
		
		return instituicoes;
	}

	public Instituicao findInstituicao(Long ri) {
		
		Optional<Instituicao> instituicao = instituicaoRepository.findById(ri);

		return instituicao.get();
	}
	
	
	public Instituicao updateInstituicao(Long ri, InstituicaoDto instituicaoDto) {

		Optional<Instituicao> optInstituicao = instituicaoRepository.findById(ri);
		Instituicao instituicao = optInstituicao.get();

		instituicao.setNome(instituicaoDto.getNome());
		instituicao.setContato(instituicaoDto.getContato());
		instituicao.setDetalhes(instituicaoDto.getDetalhes());

		instituicaoRepository.save(instituicao);

		return instituicao;
	}

}