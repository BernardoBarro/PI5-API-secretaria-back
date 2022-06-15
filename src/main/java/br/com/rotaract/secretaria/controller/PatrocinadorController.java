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

import br.com.rotaract.secretaria.dto.PatrocinadorDto;
import br.com.rotaract.secretaria.model.Patrocinador;
import br.com.rotaract.secretaria.service.PatrocinadorService;

@RestController
@RequestMapping("/patrocinador")
public class PatrocinadorController {

	@Autowired
	private PatrocinadorService service;

	@PostMapping
	public ResponseEntity<Patrocinador> createPatrocinador(@RequestBody @Valid PatrocinadorDto patrocinadorDto) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.createPatrocinador(patrocinadorDto));
	}
	
	@GetMapping
	public ResponseEntity<List<Patrocinador>> listPatrocinador() {
		
		return ResponseEntity.ok(service.findPatrocinadores());	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Patrocinador> getPatrocinador(@PathVariable Long id) {
		
		return ResponseEntity.ok(service.findPatrocinador(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Patrocinador> editPatrocinador(@PathVariable Long id, 
			@RequestBody PatrocinadorDto patrocinadorEditDto) {
		
		return ResponseEntity.ok(service.updatePatrocinador(id, patrocinadorEditDto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePatrocinador(@PathVariable Long id) {

		service.deletePatrocinador(id);

		return ResponseEntity.noContent().build();
	}
}