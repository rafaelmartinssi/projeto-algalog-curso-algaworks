package com.algaworks.algalog.service;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.exception.EntidadeNaoEncontradaException;
import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {
	
	private EntregaRepository entregaRepository;
	
	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}
}
