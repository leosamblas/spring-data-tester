package com.leosamblas.tester.repository;

import java.time.LocalDate;
import java.util.List;

import com.leosamblas.tester.model.Contrato;

public interface ContratoRepositoryCustom {

	List<Contrato> findContratosByDataParcelaCustom(LocalDate dataParcela);
}
