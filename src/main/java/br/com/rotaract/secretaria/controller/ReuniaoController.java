package br.com.rotaract.secretaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rotaract.secretaria.dto.ReuniaoDto;
import br.com.rotaract.secretaria.dto.ReuniaoEditDto;
import br.com.rotaract.secretaria.model.Reuniao;
import br.com.rotaract.secretaria.service.ReuniaoService;

@RestController
@RequestMapping("/reuniao")
public class ReuniaoController {
	
	@Autowired
	private ReuniaoService service;

	@PostMapping
	public Reuniao createReuniao(@RequestBody ReuniaoDto reuniaoDto) {
		
		return service.createReuniao(reuniaoDto);
		
	}
	
	@GetMapping
	public List<Reuniao> listReuniao() {
		
		return service.FindReuniao();
		
	}
	
	@GetMapping("/{id}")
	public Reuniao getReuniao(@PathVariable Long id) {
		
		return service.findReuniao(id);
		
	}
	
	@PutMapping("/{id}")
	public Reuniao editReuniao(@PathVariable Long id, 
			@RequestBody ReuniaoEditDto reuniaoEditDto) {
		
		return service.updateReuniao(id, reuniaoEditDto);
		
	}

}
