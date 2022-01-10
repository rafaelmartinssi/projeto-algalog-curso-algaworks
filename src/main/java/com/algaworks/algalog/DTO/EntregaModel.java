package com.algaworks.algalog.DTO;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.algaworks.algalog.model.StatusEntrega;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaModel {
	
	private Long id;
	private String nomeCliente;
	private BigDecimal taxa;
	private StatusEntrega status;
	private OffsetDateTime dataPedido;
	private OffsetDateTime dataFinalizacao;
	
	private DestinatarioModel destinatario;
}
