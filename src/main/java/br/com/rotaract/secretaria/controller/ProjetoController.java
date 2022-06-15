package br.com.rotaract.secretaria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public ResponseEntity<Projeto> criacaoProjeto(@RequestBody @Valid ProjetoDto projetoDto) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createProjeto(projetoDto));
	}
	
	@GetMapping
	public ResponseEntity<List<Projeto>> getAllProjeto() {
		
		return ResponseEntity.ok(service.findProjetos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Projeto> getByProjeto(@PathVariable Long id) {
		
		return ResponseEntity.ok(service.findProjeto(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Projeto> atualizaProjeto(@PathVariable Long id, 
			@RequestBody ProjetoEditDto projetoEditDto) {
		
		return ResponseEntity.ok(service.updateProjeto(id, projetoEditDto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProjeto(@PathVariable Long id) {
		
		service.deleteProjeto(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
