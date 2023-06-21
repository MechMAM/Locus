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
@Table(name = "Imagem")
public class ImageModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String descricao;
	
	@Column (length = 255)
	private String caminho;
	
	@Column
	private LocalDateTime dataInclusao;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_espaco_id", nullable = false)
	@JsonIgnore
	private SpaceModel espaco;

	public ImageModel() {
		super();
	}

	public ImageModel(UUID id, String descricao, String caminho, LocalDateTime dataInclusao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.caminho = caminho;
		this.dataInclusao = dataInclusao;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public LocalDateTime getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(LocalDateTime dataInclusao) {
		this.dataInclusao = dataInclusao;
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
		return "ImageModel [id=" + id + ", descricao=" + descricao + ", caminho=" + caminho + ", dataInclusao="
				+ dataInclusao + "]";
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
		ImageModel other = (ImageModel) obj;
		return Objects.equals(id, other.id);
	}
	
}
	