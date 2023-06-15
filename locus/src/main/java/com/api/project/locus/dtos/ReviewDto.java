package com.api.project.locus.dtos;

import jakarta.validation.constraints.NotNull;

public class ReviewDto {
	
	@NotNull
	private String comentario;
	@NotNull
	private int notaQualidade;
	
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getNotaQualidade() {
		return notaQualidade;
	}
	public void setNotaQualidade(int notaQualidade) {
		this.notaQualidade = notaQualidade;
	}
	
}
