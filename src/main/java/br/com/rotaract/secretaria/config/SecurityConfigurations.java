package br.com.rotaract.secretaria.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.rotaract.secretaria.filter.AutenticacaoTokenFilter;
import br.com.rotaract.secretaria.repository.AssociadoRepository;
import br.com.rotaract.secretaria.service.AutenticacaoService;
import br.com.rotaract.secretaria.service.TokenService;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter{

	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private AssociadoRepository associadoRepository;
	
	private static final String ADMIN = "ADMIN";
	private static final String PRESIDENTE = "PRESIDENTE";
	private static final String VICE_PRESIDENTE = "VICE-PRESIDENTE";
	private static final String SECRETARIO = "SECRETARIO";
	private static final String ASSOCIADO = "ASSOCIADO";
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/auth").permitAll()
			.antMatchers(HttpMethod.GET, "/**")
			.hasAnyAuthority(ADMIN, PRESIDENTE, VICE_PRESIDENTE, SECRETARIO, ASSOCIADO)
			.antMatchers(HttpMethod.POST, "/projeto")
			.hasAnyAuthority(ADMIN, PRESIDENTE, VICE_PRESIDENTE, SECRETARIO, ASSOCIADO)
			//a verificação de cadastramento de edição de associado será verificado no controller
			.antMatchers(HttpMethod.PUT, "/projeto/*", "/associado/*")
			.hasAnyAuthority(ADMIN, PRESIDENTE, VICE_PRESIDENTE, SECRETARIO, ASSOCIADO)
			.antMatchers(HttpMethod.POST, "/associado", "/convidado", "/instituicao", "/patrocinador")
			.hasAnyAuthority(ADMIN, PRESIDENTE, VICE_PRESIDENTE, SECRETARIO)
			.antMatchers(HttpMethod.PUT, "/convidado/*", "/instituicao/*", "/patrocinador/*")
			.hasAnyAuthority(ADMIN, PRESIDENTE, VICE_PRESIDENTE, SECRETARIO)
			.antMatchers(HttpMethod.DELETE, "/**")
			.hasAnyAuthority(ADMIN, PRESIDENTE, VICE_PRESIDENTE)
			.anyRequest().authenticated()
			.and().cors().and().csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().addFilterBefore(new AutenticacaoTokenFilter(tokenService, associadoRepository), UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
}
