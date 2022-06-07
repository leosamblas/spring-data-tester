package com.leosamblas.tester.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.leosamblas.tester.controller.dto.ContratoResponseData;
import com.leosamblas.tester.model.Contrato;
import com.leosamblas.tester.repository.ContratoRepository;
import com.leosamblas.tester.specification.ContratoSpecification;

@Service
public class ContratoService {

	@Autowired
	private ContratoRepository contratoRepository;
	
	@Autowired
	private ContratoSpecification contratoSpecification;

	public ContratoResponseData findContratosPorDataPagamento(LocalDate localDate) {
		
		Sort sort = Sort.by("id").ascending();
		Pageable pageable = PageRequest.of(0, 100, sort);

		Page<Contrato> contratos = contratoRepository
				.findAll(contratoSpecification.findByDataParcela(localDate), pageable);

		return ContratoResponseData.toContratoResponseData(contratos.getContent());
	}
	
	public ContratoResponseData findContratoPageablePorDocumentoContrato(String documentoContrato, int pageNumber, int pageSize) {

		Sort sort = Sort.by("id").ascending();
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

		Page<Contrato> contratoPage = contratoRepository
				.findAll(contratoSpecification.findByDocumentoContrato(documentoContrato), pageable);

		return ContratoResponseData.toContratoResponseData(contratoPage.getContent());
	}
}
