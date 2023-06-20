package com.api.project.locus.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class InvoiceDto {
	
	private LocalDateTime dataPagamento;
	private float valorPagamento;
	private String statusPagamento;
	@NotNull
	private UUID reservaId;
	
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
	public String getStatusPagamento() {
		return statusPagamento;
	}
	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}
	public UUID getReservaId() {
		return reservaId;
	}
	public void setReservaId(UUID reservaId) {
		this.reservaId = reservaId;
	}

}
