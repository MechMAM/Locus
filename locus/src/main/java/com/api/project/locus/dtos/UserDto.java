package com.api.project.locus.dtos;

import java.time.LocalDate;
import java.util.Set;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDto {
	
	@Size(min = 4)
	private String nome;
	@CPF
	private String cpf;
	@NotBlank
	@Email
	private String email;
	private String telefone;
	private LocalDate dataNascimento;
	@NotBlank
	@Size(min=4)
	@NotBlank
	private String username;
	@NotBlank
	private String senha;
	
	private Set<String> acessos;
	
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
	public Set<String> getAcessos() {
		return acessos;
	}
	public void setAcessos(Set<String> acessos) {
		this.acessos = acessos;
	}
	
	

}
