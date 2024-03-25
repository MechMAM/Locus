package com.api.project.locus.models;

import java.io.Serializable;
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
@Table(name = "espaco_has_servico")
public class SpaceHasServiceModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_espaco_id", nullable = false)
	@JsonIgnore
	private SpaceModel espaco;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_servico_id", nullable = false)
	@JsonIgnore
	private ServiceModel servico;
	
	@Column
	private double valor;
	
	@Column
	private boolean gratuito;

	public SpaceHasServiceModel() {
		super();
	}

	public SpaceHasServiceModel(SpaceModel espaco, ServiceModel servico, double valor, boolean gratuito) {
		super();
		this.espaco = espaco;
		this.servico = servico;
		this.valor = valor;
		this.gratuito = gratuito;
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public SpaceModel getEspaco() {
		return espaco;
	}

	public void setEspaco(SpaceModel espaco) {
		this.espaco = espaco;
	}

	public ServiceModel getServico() {
		return servico;
	}

	public void setServico(ServiceModel servico) {
		this.servico = servico;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isGratuito() {
		return gratuito;
	}

	public void setGratuito(boolean gratuito) {
		this.gratuito = gratuito;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(espaco, gratuito, servico, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpaceHasServiceModel other = (SpaceHasServiceModel) obj;
		return Objects.equals(espaco, other.espaco) && gratuito == other.gratuito
				&& Objects.equals(servico, other.servico)
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}

	@Override
	public String toString() {
		return "SpaceHasServiceModel [espaco=" + espaco + ", servico=" + servico + ", valor=" + valor + ", gratuito="
				+ gratuito + "]";
	}
	
	

}
	