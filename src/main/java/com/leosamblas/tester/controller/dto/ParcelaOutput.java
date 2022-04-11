package com.leosamblas.tester.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ParcelaOutput {

	private LocalDate dataPagamento;

	private BigDecimal valor;
}
