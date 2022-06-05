package br.com.rotaract.secretaria.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import br.com.rotaract.secretaria.model.Associado;
import br.com.rotaract.secretaria.repository.AssociadoRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${autenticacao.jwt.expiration}")
	private String expiration;
	
	@Value("${autenticacao.jwt.secret}")
	private String secret;

	@Autowired
	private AssociadoRepository associadoRepository;
	
	public String gerarToken(Authentication authentication) {
		
		User logado = (User) authentication.getPrincipal();
		Date hoje = new Date();
		Date expiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		
		Associado associado = associadoRepository.findByEmail(logado.getUsername()).get();
		
		return Jwts.builder()
				.setIssuer("")
				.claim(expiration, logado.getAuthorities())
				.setSubject(associado.getRI().toString())
				.setIssuedAt(hoje)
				.setExpiration(expiracao)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

	public boolean isTokenValido(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Long getIdAssociado(String token) {
		Claims body = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(body.getSubject());
	}
}
