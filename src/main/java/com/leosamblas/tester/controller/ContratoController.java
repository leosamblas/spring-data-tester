package com.leosamblas.tester.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leosamblas.tester.controller.dto.ContratoResponseData;
import com.leosamblas.tester.service.ContratoService;

@RestController
@RequestMapping("/api/v1/contratos")
public class ContratoController {

	@Autowired
	private ContratoService contratoService;

	@GetMapping(value = "/parcela/{dataPagamentoParcela}")
	public ResponseEntity<ContratoResponseData> findByDataPagamento(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataPagamentoParcela) {

		ContratoResponseData response = contratoService
				.findContratosPorDataPagamento(dataPagamentoParcela);

		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/documento")
	public ResponseEntity<ContratoResponseData> findByDataPagamento(@RequestHeader String documentoContrato,
			@RequestHeader int pageNumber, @RequestHeader int pageSize) {

		ContratoResponseData response = contratoService.findContratoPageablePorDocumentoContrato(documentoContrato, pageNumber, pageSize);

		return ResponseEntity.ok(response);
	}

	@GetMapping
	public ResponseEntity<ContratoResponseData> findAll() {

		ContratoResponseData response = contratoService.findContratosPorDataPagamento(null);

		return ResponseEntity.ok(response);
	}
}
