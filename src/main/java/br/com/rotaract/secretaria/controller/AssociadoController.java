package br.com.rotaract.secretaria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public Associado createAssociado(@RequestBody @Valid AssociadoDto associadoDto) {
		
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
	public ResponseEntity<?> updateAssociado(@PathVariable Long ri, 
			@RequestBody AssociadoEditDto associadoEditDto, @AuthenticationPrincipal User usuarioLogado) {
		
		if(service.isValidAuthority(ri, usuarioLogado)) {
			Associado associado = service.updateAssociado(ri, associadoEditDto);
			return ResponseEntity.ok().body(new Associado(associado));
		}
		return new ResponseEntity<String>("Você não tem permissão", HttpStatus.FORBIDDEN);
	}
	
	@DeleteMapping("/{ri}")
	public void deleteAssociado(@PathVariable Long ri) {
		
		service.deleteAssociado(ri);
	}
	
}
