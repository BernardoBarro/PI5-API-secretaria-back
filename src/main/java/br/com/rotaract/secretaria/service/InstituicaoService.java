package br.com.rotaract.secretaria.service;

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
		
		instituicaoRepository.save(instituicao);

		return instituicao;
	}


}