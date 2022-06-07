package com.leosamblas.tester.specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.leosamblas.tester.model.Contrato;
import com.leosamblas.tester.model.Parcela;

@Component
public class ContratoSpecification {

	public Specification<Contrato> findByDataParcela(LocalDate dataParcela) {

		return (root, query, builder) -> {

			List<Predicate> predicates = new ArrayList<>();

			if (Objects.nonNull(dataParcela)) {

				Join<Contrato, Parcela> joinParcela = root.join("parcelas", JoinType.INNER);

				predicates.add(builder.equal(joinParcela.get("dataPagamento"), dataParcela));
			}

			return builder.and(predicates.toArray(new Predicate[] {}));
		};
	}

	public Specification<Contrato> findByDocumentoContrato(String documentoContrato) {

		return (root, query, builder) -> {

			List<Predicate> predicates = new ArrayList<>();

			if (Strings.isNotEmpty(documentoContrato)) {
				predicates.add(builder.equal(root.get("documentoContrato"), documentoContrato));
			}

			return builder.and(predicates.toArray(new Predicate[] {}));
		};
	}
}
