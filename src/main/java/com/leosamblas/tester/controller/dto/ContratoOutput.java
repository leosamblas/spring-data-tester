package com.leosamblas.tester.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ContratoOutput {
	
	private String codigoContrato;

	private String documentoContrato;
	
	private LocalDateTime dataCriacao;
	
	@JsonProperty("parcelas")
	@Builder.Default
	private List<ParcelaOutput> parcelas = new ArrayList<>();
}
