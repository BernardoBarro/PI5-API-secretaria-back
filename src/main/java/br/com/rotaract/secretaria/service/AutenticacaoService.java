package br.com.rotaract.secretaria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.rotaract.secretaria.model.Associado;
import br.com.rotaract.secretaria.repository.AssociadoRepository;

@Service
public class AutenticacaoService implements UserDetailsService{
	
	@Autowired
	private AssociadoRepository associadoRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Associado> optAssociado = associadoRepository.findByEmail(username);
		
		if(optAssociado.isPresent()) {
			Associado associado = optAssociado.get();
			return User.withUsername(associado.getEmail())
						.password(associado.getSenha())
						.authorities(associado.getCargo().getAcesso().getNome())
						.build();
		}
		
		throw new UsernameNotFoundException("Associado não encontrado");
	}

}
