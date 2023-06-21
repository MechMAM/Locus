package com.api.project.locus.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Servico")
public class ServiceModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(nullable = false, length = 50)
	private String nome;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String descricao;
	
	@Column
	private LocalDateTime dataInclusao;
	
	@Column
	private LocalDateTime dataModificacao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "servico")
	private Set<SpaceHasServiceModel> espacos = new HashSet<>();
	
	@Column
	private boolean status;

	public ServiceModel() {
		super();
	}

	public ServiceModel(UUID id, String nome, String descricao, LocalDateTime dataInclusao,
			LocalDateTime dataModificacao, boolean status) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
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

	public Set<SpaceHasServiceModel> getEspacos() {
		return espacos;
	}

	public void setEspacos(Set<SpaceHasServiceModel> espacos) {
		this.espacos = espacos;
	}

	@Override
	public String toString() {
		return "ServiceModel [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", dataInclusao="
				+ dataInclusao + ", dataModificacao=" + dataModificacao + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceModel other = (ServiceModel) obj;
		return Objects.equals(nome, other.nome);
	}
	
}
	