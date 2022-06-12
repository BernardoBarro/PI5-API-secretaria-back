package br.com.rotaract.secretaria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rotaract.secretaria.dto.LoginDto;
import br.com.rotaract.secretaria.dto.TokenDto;
import br.com.rotaract.secretaria.exceptions.UnauthorizedException;
import br.com.rotaract.secretaria.service.TokenService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> autenteicar(@RequestBody @Valid LoginDto loginDto) {
		
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = loginDto.converter();

		try {
			Authentication authentication = authManager.authenticate(usernamePasswordAuthenticationToken);
			String token = tokenService.gerarToken(authentication);
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
		} catch (AuthenticationException e) {
			throw new UnauthorizedException("Não foi possivel realizar a autenticação");
		}
		
	}
}
