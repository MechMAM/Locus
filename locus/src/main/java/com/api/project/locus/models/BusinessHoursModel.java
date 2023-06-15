package com.api.project.locus.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Horario_Funcionamento")
public class BusinessHoursModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column (nullable = false)
	private LocalTime horarioEntrada;
	
	@Column (nullable = false)
	private LocalTime horarioSaida;
	
	@Column
	private LocalDateTime dataInclusao;
	
	@Column
	private LocalDateTime dataModificacao;

	public BusinessHoursModel() {
		super();
	}

	public BusinessHoursModel(UUID id, LocalTime horarioEntrada, LocalTime horarioSaida, LocalDateTime dataInclusao,
			LocalDateTime dataModificacao) {
		super();
		this.id = id;
		this.horarioEntrada = horarioEntrada;
		this.horarioSaida = horarioSaida;
		this.dataInclusao = dataInclusao;
		this.dataModificacao = dataModificacao;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BusinessHoursModel [id=" + id + ", horarioEntrada=" + horarioEntrada + ", horarioSaida=" + horarioSaida
				+ ", dataInclusao=" + dataInclusao + ", dataModificacao=" + dataModificacao + "]";
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
		BusinessHoursModel other = (BusinessHoursModel) obj;
		return Objects.equals(id, other.id);
	}

}
	