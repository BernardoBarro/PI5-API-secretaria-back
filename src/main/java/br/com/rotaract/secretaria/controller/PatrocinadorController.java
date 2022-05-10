package br.com.rotaract.secretaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rotaract.secretaria.dto.PatrocinadorDto;
import br.com.rotaract.secretaria.model.Patrocinador;
import br.com.rotaract.secretaria.service.PatrocinadorService;

@RestController
@RequestMapping("/patrocinador")
public class PatrocinadorController {

	@Autowired
	private PatrocinadorService service;

	@PostMapping
	public Patrocinador createPatrocinador(@RequestBody PatrocinadorDto patrocinadorDto) {

		return service.createPatrocinador(patrocinadorDto);

	}
}