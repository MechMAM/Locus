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
@Table(name = "avaliacao")
public class ReviewModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false)
	private String comentario;
	@Column(nullable = false)
	private int notaQualidade;
	@Column
	private LocalDateTime dataInclusao;
	@Column
	private LocalDateTime dataModificacao;
	
	public ReviewModel() {
		super();
	}

	public ReviewModel(UUID id, String comentario, int notaQualidade, LocalDateTime dataInclusao,
			LocalDateTime dataModificacao) {
		super();
		this.id = id;
		this.comentario = comentario;
		this.notaQualidade = notaQualidade;
		this.dataInclusao = dataInclusao;
		this.dataModificacao = dataModificacao;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getNotaQualidade() {
		return notaQualidade;
	}

	public void setNotaQualidade(int notaQualidade) {
		this.notaQualidade = notaQualidade;
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
		ReviewModel other = (ReviewModel) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ReviewModel [id=" + id + ", comentario=" + comentario + ", notaQualidade=" + notaQualidade
				+ ", dataInclusao=" + dataInclusao + ", dataModificacao=" + dataModificacao + "]";
	}

}
