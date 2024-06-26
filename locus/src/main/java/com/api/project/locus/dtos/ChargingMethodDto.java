package com.api.project.locus.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ChargingMethodDto {
	
	@NotBlank
	private String tipoCobranca;
	@NotNull
	private LocalDateTime dataVencimento;
	@NotNull
	private UUID tituloId;
	
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
	public UUID getTituloId() {
		return tituloId;
	}
	public void setTituloId(UUID tituloId) {
		this.tituloId = tituloId;
	}
	
	
	

}
