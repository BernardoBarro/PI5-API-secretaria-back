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

import br.com.rotaract.secretaria.dto.ConvidadoDto;
import br.com.rotaract.secretaria.model.Convidado;
import br.com.rotaract.secretaria.service.ConvidadoService;


@RestController
@RequestMapping("/convidado")
public class ConvidadoController {

	@Autowired
	private ConvidadoService service;

	@PostMapping
	public ResponseEntity<Convidado> createConvidado(@RequestBody @Valid ConvidadoDto convidadoDto) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.createConvidado(convidadoDto));
	}

	@GetMapping
	public ResponseEntity<List<Convidado>> listConvidado() {
		
		return ResponseEntity.ok(service.findConvidados());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Convidado> getConvidado(@PathVariable Long id) {
		
		return ResponseEntity.ok(service.findConvidado(id));
	}
	
	 
	@PutMapping("/{id}")
	public ResponseEntity<Convidado> editConvidado(@PathVariable Long id, 
			@RequestBody ConvidadoDto convidadoEditDto) {

		return ResponseEntity.ok(service.updateConvidado(id, convidadoEditDto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteConvidado(@PathVariable Long id) {

		service.deleteConvidado(id);
		
		return ResponseEntity.noContent().build();
	}

}
	
