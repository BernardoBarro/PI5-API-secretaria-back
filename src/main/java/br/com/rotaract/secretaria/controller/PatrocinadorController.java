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

import br.com.rotaract.secretaria.dto.PatrocinadorDto;
import br.com.rotaract.secretaria.model.Patrocinador;
import br.com.rotaract.secretaria.service.PatrocinadorService;

@RestController
@RequestMapping("/patrocinador")
public class PatrocinadorController {

	@Autowired
	private PatrocinadorService service;

	@PostMapping
	public Patrocinador createPatrocinador(@RequestBody PatrocinadorDto patrocinadorDto) {

		return service.createPatrocinador(patrocinadorDto);
	}
	
	@GetMapping
	public List<Patrocinador> listPatrocinador() {
		
		return service.findPatrocinador();	
	}
	
	@GetMapping("/{id}")
	public Patrocinador getPatrocinador(@PathVariable Long id) {
		
		return service.findPatrocinador(id);
	}
	
	@PutMapping("/{id}")
	public Patrocinador editPatrocinador(@PathVariable Long id, 
			@RequestBody PatrocinadorDto patrocinadorEditDto) {
		
		return service.updatePatrocinador(id, patrocinadorEditDto);
		
	}
	
	@DeleteMapping("/{id}")
	public void deletePatrocinador(@PathVariable Long id) {

		service.deletePatrocinador(id);

	}
}