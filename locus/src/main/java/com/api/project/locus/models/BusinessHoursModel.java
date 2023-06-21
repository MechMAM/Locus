package com.api.project.locus.models;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
@Table(name = "Horario_Funcionamento")
public class BusinessHoursModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column (nullable = false)
	private LocalTime horarioAbertura;
	
	@Column (nullable = false)
	private LocalTime horarioFechamento;
	
	@Column
	private boolean horarioDiaTodo;
	
	@Column
	private DayOfWeek diaSemana;
	
	@Column
	private LocalDateTime dataInclusao;
	
	@Column
	private LocalDateTime dataModificacao;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_espaco_id", nullable = false)
	@JsonIgnore
	private SpaceModel espaco;
	
	public BusinessHoursModel() {
		super();
	}

	public BusinessHoursModel(LocalTime horarioAbertura, LocalTime horarioFechamento, DayOfWeek diaSemana) {
		super();
		this.horarioAbertura = horarioAbertura;
		this.horarioFechamento = horarioFechamento;
		this.diaSemana = diaSemana;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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


	public boolean isHorarioDiaTodo() {
		return horarioDiaTodo;
	}

	public void setHorarioDiaTodo(boolean horarioDiaTodo) {
		this.horarioDiaTodo = horarioDiaTodo;
	}

	public SpaceModel getEspaco() {
		return espaco;
	}

	public void setEspaco(SpaceModel espaco) {
		this.espaco = espaco;
	}

	public DayOfWeek getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DayOfWeek diaSemana) {
		this.diaSemana = diaSemana;
	}

	@Override
	public String toString() {
		return "BusinessHoursModel [id=" + id + ", horarioAbertura=" + horarioAbertura + ", horarioFechamento="
				+ horarioFechamento + ", diaSemana=" + diaSemana + ", dataInclusao=" + dataInclusao
				+ ", dataModificacao=" + dataModificacao + "]";
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
	