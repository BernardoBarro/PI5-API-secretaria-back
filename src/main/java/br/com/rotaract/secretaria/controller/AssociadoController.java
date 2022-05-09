package br.com.rotaract.secretaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rotaract.secretaria.dto.AssociadoDto;
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
	
}
