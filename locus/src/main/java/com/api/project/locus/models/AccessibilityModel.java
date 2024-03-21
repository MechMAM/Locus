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
@Table(name = "Acessibilidade")
public class AccessibilityModel implements Serializable{
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
	
	@Column
	private boolean status;
	
//	@ManyToMany(fetch = FetchType.LAZY,
//			cascade = {
//					CascadeType.PERSIST,
//					CascadeType.MERGE
//					},
//			mappedBy = "acessibilidades")
//	@JsonIgnore
//	private Set<SpaceModel> espacosAcessibilidade = new HashSet<>();;

	public AccessibilityModel() {
		super();
	}

	public AccessibilityModel(String nome, String descricao, LocalDateTime dataInclusao,
			LocalDateTime dataModificacao, boolean status) {
		super();
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

//	public Set<SpaceModel> getEspacosAcessibilidade() {
//		return espacosAcessibilidade;
//	}
//
//	public void setEspacosAcessibilidade(Set<SpaceModel> espacosAcessibilidade) {
//		this.espacosAcessibilidade = espacosAcessibilidade;
//	}

	@Override
	public String toString() {
		return "AccessibilityModel [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", dataInclusao="
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
		AccessibilityModel other = (AccessibilityModel) obj;
		return Objects.equals(nome, other.nome);
	}
	
}
	