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
@Table(name = "Endereco")
public class AddressModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(nullable = false, length = 50)
	private String bairro;
	
	@Column(nullable = false, length = 75)
	private String logradouro;
	
	@Column(nullable = false, length = 20)
	private String numero;
	
	@Column(length = 50)
	private String complemento;
	
	@Column(nullable = false, length = 50)
	private String cidade;
	
	@Column(nullable = false, length = 50)
	private String estado;
	
	@Column(nullable = false, length = 50)
	private String pais;
	
	@Column(nullable = false, length = 10)
	private String cep;
	
	@Column
	private LocalDateTime dataInclusao;
	
	@Column
	private LocalDateTime dataModificacao;
	
	public AddressModel() {
		super();
	}

	public AddressModel(UUID id, String bairro, String logradouro, String numero, String complemento, String cidade,
			String estado, String pais, String cep, LocalDateTime dataInclusao, LocalDateTime dataModificacao) {
		super();
		this.id = id;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.cep = cep;
		this.dataInclusao = dataInclusao;
		this.dataModificacao = dataModificacao;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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
		AddressModel other = (AddressModel) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "AddressModel [id=" + id + ", bairro=" + bairro + ", logradouro=" + logradouro + ", numero=" + numero
				+ ", complemento=" + complemento + ", cidade=" + cidade + ", estado=" + estado + ", pais=" + pais
				+ ", cep=" + cep + ", dataInclusao=" + dataInclusao + ", dataModificacao=" + dataModificacao + "]";
	}

	
	
}