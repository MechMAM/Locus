package com.api.project.locus.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "metodo_cobranca")
public class ChargingMethodModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false)
	private String tipoCobranca;
	@Column(nullable = false)
	private LocalDateTime dataVencimento;
	@Column
	private LocalDateTime dataInclusao;
	@Column
	private LocalDateTime dataModificacao;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_titulo_id", nullable = false)
	@JsonIgnore
	private InvoiceModel titulo;
	
	public ChargingMethodModel() {
		super();
	}

	public ChargingMethodModel(UUID id, String tipoCobranca, LocalDateTime dataVencimento, LocalDateTime dataInclusao,
			LocalDateTime dataModificacao) {
		super();
		this.id = id;
		this.tipoCobranca = tipoCobranca;
		this.dataVencimento = dataVencimento;
		this.dataInclusao = dataInclusao;
		this.dataModificacao = dataModificacao;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTipoCobranca() {
		return tipoCobranca;
	}

	public void setTipoCobranca(String tipoCobranca) {
		this.tipoCobranca = tipoCobranca;
	}

	public LocalDateTime getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDateTime dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDateTime getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(LocalDateTime dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public LocalDateTime getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(LocalDateTime dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public InvoiceModel getTitulo() {
		return titulo;
	}

	public void setTitulo(InvoiceModel titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "ChargingMethodModel [id=" + id + ", tipoCobranca=" + tipoCobranca + ", dataVencimento=" + dataVencimento
				+ ", dataInclusao=" + dataInclusao + ", dataModificacao=" + dataModificacao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChargingMethodModel other = (ChargingMethodModel) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
