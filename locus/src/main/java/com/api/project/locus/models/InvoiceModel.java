package com.api.project.locus.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "titulo")
public class InvoiceModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column
	private LocalDateTime dataPagamento;
	@Column
	private float valorPagamento;
	@Column
	private String statusPagamento;
	@Column
	private LocalDateTime dataInclusao;
	@Column
	private LocalDateTime dataModificacao;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_reserva_id", nullable = false)
	private BookingModel reserva;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "titulo")
	private Set<ChargingMethodModel> metodosCobranca = new HashSet<>();

		public InvoiceModel() {
		super();
	}

	public InvoiceModel(UUID id, LocalDateTime dataPagamento, float valorPagamento, String statusPagamento,
			LocalDateTime dataInclusao, LocalDateTime dataModificacao) {
		super();
		this.id = id;
		this.dataPagamento = dataPagamento;
		this.valorPagamento = valorPagamento;
		this.statusPagamento = statusPagamento;
		this.dataInclusao = dataInclusao;
		this.dataModificacao = dataModificacao;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDateTime getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDateTime dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public float getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(float valorPagamento) {
		this.valorPagamento = valorPagamento;
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
	
	public String getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public BookingModel getReserva() {
		return reserva;
	}

	public void setReserva(BookingModel reserva) {
		this.reserva = reserva;
	}

	public Set<ChargingMethodModel> getMetodosCobranca() {
		return metodosCobranca;
	}

	public void setMetodosCobranca(Set<ChargingMethodModel> metodosCobranca) {
		this.metodosCobranca = metodosCobranca;
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
		InvoiceModel other = (InvoiceModel) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "InvoiceModel [id=" + id + ", dataPagamento=" + dataPagamento + ", valorPagamento=" + valorPagamento
				+ ", statusPagamento=" + statusPagamento + ", dataInclusao=" + dataInclusao + ", dataModificacao="
				+ dataModificacao + "]";
	}
	
}
