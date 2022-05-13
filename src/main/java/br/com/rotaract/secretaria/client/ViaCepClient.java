package br.com.rotaract.secretaria.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.rotaract.secretaria.dto.ViaCepObject;

@FeignClient(name="ViaCep", url="https://viacep.com.br/ws")
public interface ViaCepClient {

	@GetMapping(value = "/{cep}/json/", consumes = MediaType.APPLICATION_JSON_VALUE)
	ViaCepObject getEndereco(@PathVariable(name = "cep") String cep);
}
