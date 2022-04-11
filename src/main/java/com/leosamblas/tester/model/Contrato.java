package com.leosamblas.tester.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@ToString(exclude = "parcelas")
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Entity(name = "contrato")
public class Contrato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String codigoContrato;

	private String documentoContrato;

	@Builder.Default
	private LocalDateTime dataCriacao = LocalDateTime.now();

	private LocalDateTime dataAlteracao;

	private LocalDateTime dataExclusao;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "contrato")
	private List<Parcela> parcelas;
}
