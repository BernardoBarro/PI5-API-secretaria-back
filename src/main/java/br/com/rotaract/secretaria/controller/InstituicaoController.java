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

import br.com.rotaract.secretaria.dto.InstituicaoDto;
import br.com.rotaract.secretaria.model.Instituicao;
import br.com.rotaract.secretaria.service.InstituicaoService;

@RestController
@RequestMapping("/instituicao")
public class InstituicaoController {

	@Autowired
	private InstituicaoService service;

	@PostMapping
	public ResponseEntity<Instituicao> createInstituicao(@RequestBody @Valid InstituicaoDto instituicaoDto) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.createInstituicao(instituicaoDto));
	}

	@GetMapping
	public ResponseEntity<List<Instituicao>> listInstituicao() {
		
		return ResponseEntity.ok(service.findInstituicoes());
	}
	
	@GetMapping("/{ri}")
	public ResponseEntity<Instituicao> getInstituicao(@PathVariable Long ri) {
		
		return ResponseEntity.ok(service.findInstituicao(ri));
	}
	
	@PutMapping("/{ri}")
	public ResponseEntity<Instituicao> editInstituicao(@PathVariable Long ri, 
			@RequestBody InstituicaoDto instituicaoEditDto) {

		return ResponseEntity.ok(service.updateInstituicao(ri, instituicaoEditDto));
	}
	
	@DeleteMapping("/{ri}")
	public ResponseEntity<?> deleteInstituicao(@PathVariable Long ri) {
		
		service.deleteInstituicao(ri);
		
		return ResponseEntity.noContent().build();
	}

}
	
