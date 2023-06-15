package com.api.project.locus.dtos;

import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;

public class BusinessHoursDto {
	
	@NotNull
	private LocalTime horarioEntrada;
	
	@NotNull
	private LocalTime horarioSaida;

	public LocalTime getHorarioEntrada() {
		return horarioEntrada;
	}

	public void setHorarioEntrada(LocalTime horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}

	public LocalTime getHorarioSaida() {
		return horarioSaida;
	}

	public void setHorarioSaida(LocalTime horarioSaida) {
		this.horarioSaida = horarioSaida;
	}
	
}
