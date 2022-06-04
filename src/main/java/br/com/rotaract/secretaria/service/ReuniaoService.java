package br.com.rotaract.secretaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rotaract.secretaria.dto.ReuniaoDto;
import br.com.rotaract.secretaria.dto.ReuniaoEditDto;
import br.com.rotaract.secretaria.model.Reuniao;
import br.com.rotaract.secretaria.repository.ReuniaoRepository;

@Service
public class ReuniaoService {
	
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
	
	public List<Reuniao> FindReuniao(){
		
		List<Reuniao> reuniao = reuniaoRepository.findAll();
		
		return reuniao;
	}
	
    public Reuniao findReuniao(Long id) {
		
		Optional<Reuniao> reuniao = reuniaoRepository.findById(id);

		return reuniao.get();
	}
	
	
	public Reuniao updateReuniao(Long id, ReuniaoEditDto reuniaoEditDto) {

		Optional<Reuniao> optReuniao = reuniaoRepository.findById(id);
		Reuniao reuniao = optReuniao.get();
		

		reuniao.setAssunto(reuniaoEditDto.getAssunto());
		reuniao.setNome(reuniaoEditDto.getNome());
		reuniao.setLocal(reuniaoEditDto.getLocal());
		reuniao.setDataReuniao(reuniaoEditDto.getDataReuniao());
		
		reuniaoRepository.save(reuniao);

		return reuniao;
	}
	
	public void deleteReuniao(Long id) {

		Optional<Reuniao> optReuniao = reuniaoRepository.findById(id);
		if(optReuniao.isPresent()) {
			reuniaoRepository.delete(optReuniao.get());
		}
	}
}
