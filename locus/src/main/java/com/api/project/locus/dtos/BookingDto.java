package com.api.project.locus.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class BookingDto {
	
	@NotNull
	private LocalDateTime dataInicio;
	@NotNull
	private LocalDateTime dataFim;
	@NotNull
	private String timeZone;
	@NotNull
	private UUID espacoId;
	@NotNull
	private Long usuarioId;
	private UUID avaliacaoId;
	
	public LocalDateTime getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDateTime getDataFim() {
		return dataFim;
	}
	public void setDataFim(LocalDateTime dataFim) {
		this.dataFim = dataFim;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public UUID getEspacoId() {
		return espacoId;
	}
	public void setEspacoId(UUID espacoId) {
		this.espacoId = espacoId;
	}
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	public UUID getAvaliacaoId() {
		return avaliacaoId;
	}
	public void setAvaliacaoId(UUID avaliacaoId) {
		this.avaliacaoId = avaliacaoId;
	}
	
	
	

}
