package com.api.project.locus.dtos;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
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
	@NotNull
	private UUID empresaId;
	
	@NotNull
	private Set<UUID> acessibilidades = new HashSet<>();
	@NotNull
	private Set<UUID> diferenciais = new HashSet<>();
	@NotNull
	private Set<UUID> propositos = new HashSet<>();
	
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
	public UUID getEmpresaId() {
		return empresaId;
	}
	public void setEmpresaId(UUID empresaId) {
		this.empresaId = empresaId;
	}
	public Set<UUID> getAcessibilidades() {
		return acessibilidades;
	}
	public void setAcessibilidades(Set<UUID> acessibilidades) {
		this.acessibilidades = acessibilidades;
	}
	public Set<UUID> getDiferenciais() {
		return diferenciais;
	}
	public void setDiferenciais(Set<UUID> diferenciais) {
		this.diferenciais = diferenciais;
	}
	public Set<UUID> getPropositos() {
		return propositos;
	}
	public void setPropositos(Set<UUID> propositos) {
		this.propositos = propositos;
	}
	
	

	
}
