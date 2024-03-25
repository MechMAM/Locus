package com.api.project.locus.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Empresa")
public class CompanyModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false, length = 50)
	private String nome;
	@Column(nullable = false, length = 80)
	private String razaoSocial;
	@Column(nullable = false, length = 18)
	private String cnpj;
	@Column(nullable = false, length = 70)
	private String email;
	@Column
	private LocalDateTime dataCriacao;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
					})
	@JoinTable(
			  name = "Empresa_has_Usuario", 
			  joinColumns = @JoinColumn(name = "empresa_emp_id", referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "usuario_usu_id", referencedColumnName = "id"))
	private Set<UserModel> usuarioId = new HashSet<>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "empresa")
	private Set<SpaceModel> espacosDaEmpresa = new HashSet<>();

	public CompanyModel() {
		super();
	}

	public CompanyModel(UUID id, String nome, String razaoSocial, String cnpj, String email, Set<UserModel> usuarioId) {
		super();
		this.id = id;
		this.nome = nome;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.email = email;
		this.usuarioId = usuarioId;
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

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Set<UserModel> getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Set<UserModel> usuarioId) {
		this.usuarioId = usuarioId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<SpaceModel> getEspacosDaEmpresa() {
		return espacosDaEmpresa;
	}

	public void setEspacosDaEmpresa(Set<SpaceModel> espacosDaEmpresa) {
		this.espacosDaEmpresa = espacosDaEmpresa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanyModel other = (CompanyModel) obj;
		return Objects.equals(cnpj, other.cnpj);
	}

	@Override
	public String toString() {
		return "CompanyModel [id=" + id + ", nome=" + nome + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj
				+ ", email=" + email + ", usuarioId=" + usuarioId + "]";
	}
	
	
}
