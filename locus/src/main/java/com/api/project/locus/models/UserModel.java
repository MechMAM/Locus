package com.api.project.locus.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
import jakarta.persistence.Table;

@Entity
@Table(	name = "Usuario")
public class UserModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = true, length = 50)
	private String nome;

	@Column(nullable = true, unique = true, length = 15)
	private String cpf;

	@Column(nullable = false, unique = true, length = 60)
	private String email;

	@Column(nullable = true, length = 20)
	private String telefone;

	@Column
	private LocalDate dataNascimento;
	
	@Column(nullable = false, unique = true, length = 50)
	private String username;
	
	@JsonIgnore
	@Column(nullable = false, length = 255)
	private String senha;

	private LocalDateTime createdDate;

	@Column
	private boolean status;

	@ManyToMany(
			fetch = FetchType.LAZY, 
			cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
			mappedBy = "usuarioId")
	@JsonIgnore
	private Set<CompanyModel> empresaId = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_has_acesso", 
				joinColumns = @JoinColumn(name = "usuario_id"), 
				inverseJoinColumns = @JoinColumn(name = "tipo_acesso_id"))
	private Set<AccessTypeModel> acessos = new HashSet<>();

	public UserModel() {
		super();
	}

	public UserModel(Long id, String nome, String cpf, String email, String telefone, LocalDate dataNascimento,
			String username, String senha, LocalDateTime createdDate, boolean status) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.username = username;
		this.senha = senha;
		this.createdDate = createdDate;
		this.status = status;
	}

	public UserModel(String username, String email, String senha) {
		this.username = username;
		this.email = email;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Set<CompanyModel> getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Set<CompanyModel> empresaId) {
		this.empresaId = empresaId;
	}
	
	public Set<AccessTypeModel> getAcessos() {
		return acessos;
	}

	public void setAcessos(Set<AccessTypeModel> acessos) {
		this.acessos = acessos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", telefone=" + telefone
				+ ", dataNascimento=" + dataNascimento + ", senha=" + senha + ", createdDate=" + createdDate
				+ ", status=" + status + ", empresaId=" + empresaId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserModel other = (UserModel) obj;
		return Objects.equals(cpf, other.cpf);
	}

}
