package br.com.rotaract.secretaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rotaract.secretaria.dto.ReuniaoDto;
import br.com.rotaract.secretaria.model.Reuniao;
import br.com.rotaract.secretaria.repository.ReuniaoRepository;
import br.com.rotaract.secretaria.utils.BuildError;

@Service
public class ReuniaoService {

	private final static String NOT_FOUND = "A reunião não existe";
	
	@Autowired
	private ReuniaoRepository reuniaoRepository;
	
	public Reuniao createReuniao(ReuniaoDto reuniaoDto) {
		Reuniao reuniao = new Reuniao();
		reuniao.setAssunto(reuniaoDto.getAssunto());
		reuniao.setNome(reuniaoDto.getNome());
		reuniao.setLocal(reuniaoDto.getLocal());
		reuniao.setDataReuniao(reuniaoDto.getDataReuniao());
		
		reuniaoRepository.save(reuniao);
		
		return reuniao;
	}
	
	public List<Reuniao> findReunioes(){
		
		return reuniaoRepository.findAll();
	}
	
	public Reuniao findReuniao(Long id) {
		
		Optional<Reuniao> optReuniao = reuniaoRepository.findById(id);
		BuildError.buildNotFoundException(optReuniao, NOT_FOUND);

		return optReuniao.get();
	}
	
	
	public Reuniao updateReuniao(Long id, ReuniaoDto reuniaoDto) {

		Optional<Reuniao> optReuniao = reuniaoRepository.findById(id);
		BuildError.buildNotFoundException(optReuniao, NOT_FOUND);
		Reuniao reuniao = optReuniao.get();
		

		reuniao.setAssunto(reuniaoDto.getAssunto());
		reuniao.setNome(reuniaoDto.getNome());
		reuniao.setLocal(reuniaoDto.getLocal());
		reuniao.setDataReuniao(reuniaoDto.getDataReuniao());
		
		reuniaoRepository.save(reuniao);

		return reuniao;
	}
	
	public void deleteReuniao(Long id) {

		Optional<Reuniao> optReuniao = reuniaoRepository.findById(id);
		BuildError.buildNotFoundException(optReuniao, NOT_FOUND);
		reuniaoRepository.delete(optReuniao.get());
	}
}
