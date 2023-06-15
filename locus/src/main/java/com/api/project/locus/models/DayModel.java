package com.api.project.locus.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Dia_Semana")
public class DayModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column
	private boolean domingo;
	
	@Column
	private boolean segunda;
	
	@Column
	private boolean terca;
	
	@Column
	private boolean quarta;
	
	@Column
	private boolean quinta;
	
	@Column
	private boolean sexta;
	
	@Column
	private boolean sabado;
	
	@Column
	private LocalDateTime dataInclusao;
	
	@Column
	private LocalDateTime dataModificacao;


	public DayModel() {
		super();
	}


	public DayModel(UUID id, boolean domingo, boolean segunda, boolean terca, boolean quarta, boolean quinta,
			boolean sexta, boolean sabado, LocalDateTime dataInclusao, LocalDateTime dataModificacao) {
		super();
		this.id = id;
		this.domingo = domingo;
		this.segunda = segunda;
		this.terca = terca;
		this.quarta = quarta;
		this.quinta = quinta;
		this.sexta = sexta;
		this.sabado = sabado;
		this.dataInclusao = dataInclusao;
		this.dataModificacao = dataModificacao;
	}


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public boolean isDomingo() {
		return domingo;
	}


	public void setDomingo(boolean domingo) {
		this.domingo = domingo;
	}


	public boolean isSegunda() {
		return segunda;
	}


	public void setSegunda(boolean segunda) {
		this.segunda = segunda;
	}


	public boolean isTerca() {
		return terca;
	}


	public void setTerca(boolean terca) {
		this.terca = terca;
	}


	public boolean isQuarta() {
		return quarta;
	}


	public void setQuarta(boolean quarta) {
		this.quarta = quarta;
	}


	public boolean isQuinta() {
		return quinta;
	}


	public void setQuinta(boolean quinta) {
		this.quinta = quinta;
	}


	public boolean isSexta() {
		return sexta;
	}


	public void setSexta(boolean sexta) {
		this.sexta = sexta;
	}


	public boolean isSabado() {
		return sabado;
	}


	public void setSabado(boolean sabado) {
		this.sabado = sabado;
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
		return "DayModel [id=" + id + ", domingo=" + domingo + ", segunda=" + segunda + ", terca=" + terca + ", quarta="
				+ quarta + ", quinta=" + quinta + ", sexta=" + sexta + ", sabado=" + sabado + ", dataInclusao="
				+ dataInclusao + ", dataModificacao=" + dataModificacao + "]";
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
		DayModel other = (DayModel) obj;
		return Objects.equals(id, other.id);
	}
	
}
	