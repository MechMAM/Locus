package com.api.project.locus.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ImageDto {
	
	@NotBlank
	private String descricao;
	@NotNull
	private UUID espacoId;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public UUID getEspacoId() {
		return espacoId;
	}

	public void setEspacoId(UUID espacoId) {
		this.espacoId = espacoId;
	}
	
}
