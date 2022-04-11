package com.leosamblas.tester.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leosamblas.tester.controller.dto.ContratoResponseData;
import com.leosamblas.tester.service.ContratoService;

@RestController
@RequestMapping("/api/v1/contratos")
public class ContratoController {

	@Autowired
	private ContratoService contratoService;

	@GetMapping(value = "/{dataPagamentoParcela}")
	public ResponseEntity<ContratoResponseData> findByDataPagamento(@PathVariable String dataPagamentoParcela) {

		ContratoResponseData response = contratoService.findContratosPorDataPagamento(LocalDate.parse(dataPagamentoParcela));

		return ResponseEntity.ok(response);
	}

	@GetMapping
	public ResponseEntity<ContratoResponseData> findAll() {

		ContratoResponseData response = contratoService.findContratosPorDataPagamento(null);

		return ResponseEntity.ok(response);
	}
}
