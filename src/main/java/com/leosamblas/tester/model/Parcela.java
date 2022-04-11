package com.leosamblas.tester.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@ToString(exclude = "contrato")
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Entity(name = "parcela")
public class Parcela implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate dataPagamento;

	@Digits(integer = 16, fraction = 2)
	private BigDecimal valor;

	@ManyToOne(fetch = FetchType.LAZY)
	private Contrato contrato;

}
