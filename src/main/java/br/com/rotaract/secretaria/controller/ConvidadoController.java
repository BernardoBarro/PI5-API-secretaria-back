package br.com.rotaract.secretaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rotaract.secretaria.dto.ConvidadoDto;
import br.com.rotaract.secretaria.model.Convidado;
import br.com.rotaract.secretaria.service.ConvidadoService;


@RestController
@RequestMapping("/convidado")
public class ConvidadoController {

	@Autowired
	private ConvidadoService service;

	@PostMapping
	public Convidado createConvidado(@RequestBody ConvidadoDto convidadoDto) {

		return service.createConvidado(convidadoDto);

	}

	@GetMapping
	public List<Convidado> listConvidado() {
		
		return service.findConvidado();
		
	}
	
	@GetMapping("/{ri}")
	public Convidado getConvidado(@PathVariable Long ri) {
		
		return service.findConvidado(ri);
		
	}
	
	 
	@PutMapping("/{ri}")
	public Convidado editConvidado(@PathVariable Long ri, 
			@RequestBody ConvidadoDto convidadoEditDto) {

		return service.updateConvidado(ri, convidadoEditDto);

	}

}
	