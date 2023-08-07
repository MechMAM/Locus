package com.api.project.locus.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.api.project.locus.models.enums.AccessTypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_acesso")
public class AccessTypeModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(nullable = false, length = 50)
	private AccessTypeEnum nomeFuncao;
	
	@Column
	private LocalDateTime dataInclusao;
	
	@Column
	private LocalDateTime dataModificacao;
	
	@Column
	private boolean status;
	
	public AccessTypeModel() {
		super();
	}

	public AccessTypeModel(UUID id, AccessTypeEnum nomeFuncao, LocalDateTime dataInclusao,
			LocalDateTime dataModificacao, boolean status) {
		super();
		this.id = id;
		this.nomeFuncao = nomeFuncao;
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

	public AccessTypeEnum getNomeFuncao() {
		return nomeFuncao;
	}

	public void setNomeFuncao(AccessTypeEnum nomeFuncao) {
		this.nomeFuncao = nomeFuncao;
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
		AccessTypeModel other = (AccessTypeModel) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "AccessTypeModel [id=" + id + ", nomeFuncao=" + nomeFuncao + ", dataInclusao=" + dataInclusao
				+ ", dataModificacao=" + dataModificacao + ", status=" + status + "]";
	}
	
}
	