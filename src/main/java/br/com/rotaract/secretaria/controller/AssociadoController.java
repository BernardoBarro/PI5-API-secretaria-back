package br.com.rotaract.secretaria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
import br.com.rotaract.secretaria.exceptions.UnauthorizedException;
import br.com.rotaract.secretaria.model.Associado;
import br.com.rotaract.secretaria.service.AssociadoService;

@RestController
@RequestMapping("/associado")
public class AssociadoController {
	
	@Autowired
	private AssociadoService service;

	@PostMapping
	public ResponseEntity<Associado> createAssociado(@RequestBody @Valid AssociadoDto associadoDto) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createAssociado(associadoDto));
	}
	
	@GetMapping
	public ResponseEntity<List<Associado>> getAllAssociados() {
		
		return ResponseEntity.ok(service.findAssociados());
	}
	
	@GetMapping("/{ri}")
	public ResponseEntity<Associado> getById(@PathVariable Long ri) {
		
		return ResponseEntity.ok(service.findAssociado(ri));
	}
	
	@GetMapping("/cargo")
	public ResponseEntity<List<PessoaCargo>> getByCargo() {

		return ResponseEntity.ok(service.getByCargo());
	}
	
	@PutMapping("/{ri}")
	public ResponseEntity<Associado> updateAssociado(@PathVariable Long ri, 
			@RequestBody AssociadoEditDto associadoEditDto) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String usuarioLogado = ((UserDetails)principal).getUsername();
		if(service.isValidAuthority(ri, usuarioLogado)) {
			Associado associado = service.updateAssociado(ri, associadoEditDto);
			return ResponseEntity.ok().body(new Associado(associado));
		}
		throw new UnauthorizedException("Você não tem permissão");
	}
	
	@DeleteMapping("/{ri}")
	public ResponseEntity<?> deleteAssociado(@PathVariable Long ri) {
		
		service.deleteAssociado(ri);
		
		return ResponseEntity.noContent().build();
	}
	
}
