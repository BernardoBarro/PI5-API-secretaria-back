package br.com.rotaract.secretaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rotaract.secretaria.dto.ProjetoDto;
import br.com.rotaract.secretaria.model.Projeto;
import br.com.rotaract.secretaria.service.ProjetoService;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {
	
	@Autowired
	private ProjetoService service;

	@PostMapping
	public Projeto criacaoProjeto(@RequestBody ProjetoDto projetoDto) {
		
		return service.criacaoProjeto(projetoDto);
		
	}
	
//	@GetMapping
//	public List<Associado> listAssociado() {
//		
//		return service.findAssociado();
//		
//	}
//	
//	@GetMapping("/{ri}")
//	public Associado getAssociado(@PathVariable Long ri) {
//		
//		return service.findAssociado(ri);
//		
//	}
//	
//	@PutMapping("/{ri}")
//	public Associado editAssociado(@PathVariable Long ri, 
//			@RequestBody AssociadoEditDto associadoEditDto) {
//		
//		return service.updateAssociado(ri, associadoEditDto);
//		
//	}
	
}
