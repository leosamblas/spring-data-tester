package com.leosamblas.tester.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.leosamblas.tester.model.Contrato;
import com.leosamblas.tester.model.Parcela;

@Repository
public class ContratoRepositoryImpl implements ContratoRepositoryCustom {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Contrato> findContratosByDataParcelaCustom(LocalDate dataParcela) {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Contrato> query = builder.createQuery(Contrato.class);
		Predicate predicate = builder.and();

		Root<Contrato> contratoRoot = query.from(Contrato.class);

		if (Objects.nonNull(dataParcela)) {

			Join<Contrato, Parcela> joinParcela = contratoRoot.join("parcelas", JoinType.INNER);

			predicate = builder.and(predicate, builder.equal(joinParcela.get("dataPagamento"), dataParcela));
		}

		TypedQuery<Contrato> typedQuery = manager.createQuery(query.select(contratoRoot).where(predicate));
		//typedQuery.setHint("org.hibernate.cacheable", true);

		return typedQuery.getResultList();
	}
}
