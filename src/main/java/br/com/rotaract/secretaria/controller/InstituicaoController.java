package br.com.rotaract.secretaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
	public Instituicao createInstituicao(@RequestBody InstituicaoDto instituicaoDto) {

		return service.createInstituicao(instituicaoDto);

	}

}