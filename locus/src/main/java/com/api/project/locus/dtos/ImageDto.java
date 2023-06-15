package com.api.project.locus.dtos;

import jakarta.validation.constraints.NotBlank;

public class ImageDto {
	
	@NotBlank
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
		
}
