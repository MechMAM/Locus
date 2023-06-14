package com.api.project.locus.dtos;

import jakarta.validation.constraints.NotNull;

public class ParkingDto {
	
	private int quantidadeVagas;
	
	private double valorHora;
	
	private double valorPeriodo;
	
	private double valorDiaria;
	
	@NotNull
	private Boolean gratuito;

	public int getQuantidadeVagas() {
		return quantidadeVagas;
	}

	public void setQuantidadeVagas(int quantidadeVagas) {
		this.quantidadeVagas = quantidadeVagas;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public double getValorPeriodo() {
		return valorPeriodo;
	}

	public void setValorPeriodo(double valorPeriodo) {
		this.valorPeriodo = valorPeriodo;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public Boolean getGratuito() {
		return gratuito;
	}

	public void setGratuito(Boolean gratuito) {
		this.gratuito = gratuito;
	}
			
}
