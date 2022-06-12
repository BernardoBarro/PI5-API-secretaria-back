package br.com.rotaract.secretaria.controller;

import java.util.List;

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

import br.com.rotaract.secretaria.dto.ReuniaoDto;
import br.com.rotaract.secretaria.model.Reuniao;
import br.com.rotaract.secretaria.service.ReuniaoService;

@RestController
@RequestMapping("/reuniao")
public class ReuniaoController {
	
	@Autowired
	private ReuniaoService service;

	@PostMapping
	public ResponseEntity<Reuniao> createReuniao(@RequestBody ReuniaoDto reuniaoDto) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createReuniao(reuniaoDto));
	}
	
	@GetMapping
	public ResponseEntity<List<Reuniao>> listReuniao() {
		
		return ResponseEntity.ok(service.findReunioes());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Reuniao> getReuniao(@PathVariable Long id) {
		
		return ResponseEntity.ok(service.findReuniao(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Reuniao> editReuniao(@PathVariable Long id, 
			@RequestBody ReuniaoDto reuniaoDto) {
		
		return ResponseEntity.ok(service.updateReuniao(id, reuniaoDto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteReuniao(@PathVariable Long id) {

		service.deleteReuniao(id);

		return ResponseEntity.noContent().build();
	}
}
