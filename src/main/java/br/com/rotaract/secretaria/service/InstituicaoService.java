package br.com.rotaract.secretaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rotaract.secretaria.dto.InstituicaoDto;
import br.com.rotaract.secretaria.model.Instituicao;
import br.com.rotaract.secretaria.repository.InstituicaoRepository;
import br.com.rotaract.secretaria.utils.BuildError;

@Service
public class InstituicaoService {

	private final static String NOT_FOUND = "A instituição não existe";
	
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
	
	public List<Instituicao> findInstituicoes() {
		
		return instituicaoRepository.findAll();
	}

	public Instituicao findInstituicao(Long ri) {
		
		Optional<Instituicao> optInstituicao = instituicaoRepository.findById(ri);
		BuildError.buildNotFoundException(optInstituicao, NOT_FOUND);

		return optInstituicao.get();
	}
	
	public Instituicao updateInstituicao(Long ri, InstituicaoDto instituicaoDto) {

		Optional<Instituicao> optInstituicao = instituicaoRepository.findById(ri);
		BuildError.buildNotFoundException(optInstituicao, NOT_FOUND);
		Instituicao instituicao = optInstituicao.get();

		instituicao.setNome(instituicaoDto.getNome());
		instituicao.setContato(instituicaoDto.getContato());
		instituicao.setDetalhes(instituicaoDto.getDetalhes());

		instituicaoRepository.save(instituicao);

		return instituicao;
	}

	public void deleteInstituicao(Long ri) {
		
		Optional<Instituicao> optInstituicao = instituicaoRepository.findById(ri);
		BuildError.buildNotFoundException(optInstituicao, NOT_FOUND);
		instituicaoRepository.delete(optInstituicao.get());
	}

}