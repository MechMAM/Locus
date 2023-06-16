package com.api.project.locus.dtos;

import java.time.LocalTime;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SpaceDto {
	
	@NotBlank
	private String nome;
	@NotBlank
	private String descricao;
	@NotBlank
	private String descricaoArredores;
	@NotNull
	private int capacidade;
	@NotNull
	private double area;
	private LocalTime tempoLimpeza;
	private double taxaLimpeza;
	@NotNull
	private boolean hasTaxaLimpeza;
	@NotNull
	private double precoHorario;
	@NotNull
	private UUID enderecoId;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricaoArredores() {
		return descricaoArredores;
	}
	public void setDescricaoArredores(String descricaoArredores) {
		this.descricaoArredores = descricaoArredores;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public LocalTime getTempoLimpeza() {
		return tempoLimpeza;
	}
	public void setTempoLimpeza(LocalTime tempoLimpeza) {
		this.tempoLimpeza = tempoLimpeza;
	}
	public double getTaxaLimpeza() {
		return taxaLimpeza;
	}
	public void setTaxaLimpeza(double taxaLimpeza) {
		this.taxaLimpeza = taxaLimpeza;
	}
	public boolean isHasTaxaLimpeza() {
		return hasTaxaLimpeza;
	}
	public void setHasTaxaLimpeza(boolean hasTaxaLimpeza) {
		this.hasTaxaLimpeza = hasTaxaLimpeza;
	}
	public double getPrecoHorario() {
		return precoHorario;
	}
	public void setPrecoHorario(double precoHorario) {
		this.precoHorario = precoHorario;
	}
	public UUID getEnderecoId() {
		return enderecoId;
	}
	public void setEnderecoId(UUID enderecoId) {
		this.enderecoId = enderecoId;
	}
	

	
}
