package com.leosamblas.tester.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leosamblas.tester.controller.dto.ContratoResponseData;
import com.leosamblas.tester.model.Contrato;
import com.leosamblas.tester.repository.ContratoRepository;

@Service
public class ContratoService {

	@Autowired
	private ContratoRepository contratoRepository;

	public ContratoResponseData findContratosPorDataPagamento(LocalDate localDate) {

		List<Contrato> contratos = contratoRepository.findContratosByDataParcelaCustom(localDate);

		return ContratoResponseData.toContratoResponseData(contratos);
	}
}
