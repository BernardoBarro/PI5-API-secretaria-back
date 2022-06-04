package br.com.rotaract.secretaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/{id}")
	public Convidado getConvidado(@PathVariable Long id) {
		
		return service.findConvidado(id);
		
	}
	
	 
	@PutMapping("/{id}")
	public Convidado editConvidado(@PathVariable Long id, 
			@RequestBody ConvidadoDto convidadoEditDto) {

		return service.updateConvidado(id, convidadoEditDto);

	}
	
	@DeleteMapping("/{id}")
	public void deleteConvidado(@PathVariable Long id) {

		service.deleteConvidado(id);

	}

}
	
