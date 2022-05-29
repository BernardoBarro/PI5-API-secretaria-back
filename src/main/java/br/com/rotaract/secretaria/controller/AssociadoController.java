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

import br.com.rotaract.secretaria.dto.AssociadoDto;
import br.com.rotaract.secretaria.dto.AssociadoEditDto;
import br.com.rotaract.secretaria.dto.PessoaCargo;
import br.com.rotaract.secretaria.model.Associado;
import br.com.rotaract.secretaria.service.AssociadoService;

@RestController
@RequestMapping("/associado")
public class AssociadoController {
	
	@Autowired
	private AssociadoService service;

	@PostMapping
	public Associado createAssociado(@RequestBody AssociadoDto associadoDto) {
		
		return service.createAssociado(associadoDto);
	}
	
	@GetMapping
	public List<Associado> getAllAssociados() {
		
		return service.findAssociado();
	}
	
	@GetMapping("/{ri}")
	public Associado getById(@PathVariable Long ri) {
		
		return service.findAssociado(ri);
	}
	
	@GetMapping("/cargo")
	public List<PessoaCargo> getByCargo() {

		return service.getByCargo();
	}
	
	@PutMapping("/{ri}")
	public Associado updateAssociado(@PathVariable Long ri, 
			@RequestBody AssociadoEditDto associadoEditDto) {
		
		return service.updateAssociado(ri, associadoEditDto);
	}
	
}
