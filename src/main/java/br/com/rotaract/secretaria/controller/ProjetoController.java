package br.com.rotaract.secretaria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rotaract.secretaria.dto.ProjetoDto;
import br.com.rotaract.secretaria.dto.ProjetoEditDto;
import br.com.rotaract.secretaria.model.Projeto;
import br.com.rotaract.secretaria.service.ProjetoService;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {
	
	@Autowired
	private ProjetoService service;

	@PostMapping
	public Projeto criacaoProjeto(@RequestBody @Valid ProjetoDto projetoDto) {
		
		return service.criacaoProjeto(projetoDto);
		
	}
	
	@GetMapping
	public List<Projeto> getAllProjeto() {
		
		return service.buscaProjetos();
		
	}
	
	@GetMapping("/{id}")
	public Projeto getByProjeto(@PathVariable Long id) {
		
		return service.buscaProjeto(id);
		
	}
	
	@PutMapping("/{id}")
	public Projeto atualizaProjeto(@PathVariable Long id, 
			@RequestBody ProjetoEditDto projetoEditDto) {
		
		return service.atualizaProjeto(id, projetoEditDto);
		
	}
	
}
