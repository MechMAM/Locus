package com.api.project.locus.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Estacionamento")
public class ParkingModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column
	private int quantidadeVagas;
	
	@Column
	private double valorHora;
	
	@Column
	private double valorPeriodo;
	
	@Column
	private double valorDiaria;
	
	@Column (nullable = false)
	private Boolean gratuito;
	
	@Column
	private LocalDateTime dataInclusao;
	
	@Column
	private LocalDateTime dataModificacao;
	
	@Column
	private boolean status;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_espaco_id", nullable = false)
	@JsonIgnore
	private SpaceModel espaco;

	public ParkingModel() {
		super();
	}

	public ParkingModel(UUID id, int quantidadeVagas, double valorHora, double valorPeriodo, double valorDiaria,
			Boolean gratuito, LocalDateTime dataInclusao, LocalDateTime dataModificacao, boolean status) {
		super();
		this.id = id;
		this.quantidadeVagas = quantidadeVagas;
		this.valorHora = valorHora;
		this.valorPeriodo = valorPeriodo;
		this.valorDiaria = valorDiaria;
		this.gratuito = gratuito;
		this.dataInclusao = dataInclusao;
		this.dataModificacao = dataModificacao;
		this.status = status;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SpaceModel getEspaco() {
		return espaco;
	}

	public void setEspaco(SpaceModel espaco) {
		this.espaco = espaco;
	}

	@Override
	public String toString() {
		return "ParkingModel [id=" + id + ", quantidadeVagas=" + quantidadeVagas + ", valorHora=" + valorHora
				+ ", valorPeriodo=" + valorPeriodo + ", valorDiaria=" + valorDiaria + ", gratuito=" + gratuito
				+ ", dataInclusao=" + dataInclusao + ", dataModificacao=" + dataModificacao + ", status=" + status
				+ "]";
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
		ParkingModel other = (ParkingModel) obj;
		return Objects.equals(id, other.id);
	}

}
	