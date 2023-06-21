package com.api.project.locus.dtos;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class BusinessHoursDto {
	
	@NotNull
	private LocalTime horarioAbertura;
	
	@NotNull
	private LocalTime horarioFechamento;
	
	@NotNull
	private DayOfWeek diaSemana;
	
	@NotNull
	private UUID espacoId;
	
	@NotNull
	private boolean horarioDiaTodo;
	
	public LocalTime getHorarioAbertura() {
		return horarioAbertura;
	}

	public void setHorarioAbertura(LocalTime horarioAbertura) {
		this.horarioAbertura = horarioAbertura;
	}

	public LocalTime getHorarioFechamento() {
		return horarioFechamento;
	}

	public void setHorarioFechamento(LocalTime horarioFechamento) {
		this.horarioFechamento = horarioFechamento;
	}

	public DayOfWeek getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DayOfWeek diaSemana) {
		this.diaSemana = diaSemana;
	}

	public UUID getEspacoId() {
		return espacoId;
	}

	public void setEspacoId(UUID espacoId) {
		this.espacoId = espacoId;
	}

	public boolean isHorarioDiaTodo() {
		return horarioDiaTodo;
	}

	public void setHorarioDiaTodo(boolean horarioDiaTodo) {
		this.horarioDiaTodo = horarioDiaTodo;
	}
	
}
