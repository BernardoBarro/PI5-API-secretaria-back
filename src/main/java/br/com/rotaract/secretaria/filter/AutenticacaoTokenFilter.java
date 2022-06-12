package br.com.rotaract.secretaria.filter;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.rotaract.secretaria.model.Associado;
import br.com.rotaract.secretaria.repository.AssociadoRepository;
import br.com.rotaract.secretaria.service.TokenService;
import br.com.rotaract.secretaria.utils.Validation;

public class AutenticacaoTokenFilter extends OncePerRequestFilter{

	private TokenService tokenService;
	private AssociadoRepository associadoRepository;
	
	public AutenticacaoTokenFilter(TokenService tokenService, AssociadoRepository associadoRepository) {
		this.tokenService = tokenService;
		this.associadoRepository = associadoRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recuperarToken(request);
		boolean valido = tokenService.isTokenValido(token);
		if(valido) {
			autenticarAssociado(token);
		}
		
		filterChain.doFilter(request, response);
	}

	private void autenticarAssociado(String token) {
		Long idAssociado = tokenService.getIdAssociado(token);
		Optional<Associado> optAssociado = associadoRepository.findById(idAssociado);
		Validation.validReturnObject(optAssociado, "O associado não existe");
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(optAssociado.get(), null, optAssociado.get().getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		
		return token.substring(7, token.length());
	}

}
