package com.leosamblas.tester.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.leosamblas.tester.model.Contrato;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ContratoResponseData {

	@JsonProperty("contratos")
	@Builder.Default
	private List<ContratoOutput> contratos = new ArrayList<>();	
	
	public static ContratoResponseData toContratoResponseData(List<Contrato> contratos) {
		
		ContratoResponseData responseData = new ContratoResponseData();
		
		contratos.forEach(c -> {
			
			ContratoOutput contratoOutput = ContratoOutput.builder()
					.codigoContrato(c.getCodigoContrato())
					.documentoContrato(c.getDocumentoContrato())
					.dataCriacao(c.getDataCriacao())
					.build();
			
			c.getParcelas().forEach(p -> {
				
				ParcelaOutput parcelaOutput = ParcelaOutput.builder()
						.dataPagamento(p.getDataPagamento())
						.valor(p.getValor())
						.build();
				
				contratoOutput.getParcelas().add(parcelaOutput);
			});
			
			
			responseData.getContratos().add(contratoOutput);
		});
		
		return responseData;		
	}
}
