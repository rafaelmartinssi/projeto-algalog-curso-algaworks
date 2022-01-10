package com.algaworks.algalog.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.exception.NegocioException;
import com.algaworks.algalog.model.Cliente;
import com.algaworks.algalog.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalogoClienteService {
	private ClienteRepository clienteRepository; 
	
	@Transactional
	public Cliente salvar (Cliente cliente) {
		
		if(clienteRepository.findByEmail(cliente.getEmail()) != null && cliente.getId() == null) {
			throw new NegocioException("Já existe um cliente cadastrado com esse email");
		}
				
		return clienteRepository.save(cliente);
	} 
	
	@Transactional
	public void excluir (Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
	
	public Cliente buscar (Long clienteId) {
		return clienteRepository.findById(clienteId)
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
	}
}
