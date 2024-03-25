package com.api.project.locus.dtos;

import com.api.project.locus.models.enums.AccessTypeEnum;

import jakarta.validation.constraints.NotNull;

public class AccessTypeDto {
	
	@NotNull
	private AccessTypeEnum nomeFuncao;

	public AccessTypeEnum getNomeFuncao() {
		return nomeFuncao;
	}

	public void setNomeFuncao(AccessTypeEnum nomeFuncao) {
		this.nomeFuncao = nomeFuncao;
	}
	
}
