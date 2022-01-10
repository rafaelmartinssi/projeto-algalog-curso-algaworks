package com.algaworks.algalog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.DTO.OcorrenciaModel;
import com.algaworks.algalog.mapper.OcorrenciaMapper;
import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.model.Ocorrencia;
import com.algaworks.algalog.model.input.OcorrenciaInput;
import com.algaworks.algalog.service.BuscaEntregaService;
import com.algaworks.algalog.service.RegistroOcorrenciaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {
	
	private RegistroOcorrenciaService registroOcorrenciaService;
	private OcorrenciaMapper ocorrenciaMapper;
	private BuscaEntregaService buscaEntregaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaModel registrar(@PathVariable Long entregaId,
			@Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
		Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService.registrar(entregaId, ocorrenciaInput.getDescricao());
		return ocorrenciaMapper.toModel(ocorrenciaRegistrada);
	} 
	
	@GetMapping
	public List<OcorrenciaModel> listar (@PathVariable Long entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		return ocorrenciaMapper.toListModel(entrega.getOcorrencias());
	}
	
}
