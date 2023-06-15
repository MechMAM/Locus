package com.api.project.locus.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public class BookingDto {
	
	@NotNull
	private LocalDateTime dataInicio;
	@NotNull
	private LocalDateTime dataFim;
	@NotNull
	private String timeZone;
	
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
	
	
	

}
