package com.api.project.locus.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class BookingModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false)
	private LocalDateTime dataInicio;
	@Column(nullable = false)
	private LocalDateTime dataFim;
	@Column(nullable = false)
	private String timeZone;
	@Column
	private double preco;
	@Column
	private LocalDateTime dataInclusao;
	@Column
	private LocalDateTime dataModificacao;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_espaco_id", nullable = false)
	private SpaceModel espaco;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_usuario_id", nullable = false)
	private UserModel usuario;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_avaliacao_id")
	private ReviewModel avaliacao;
	
	public BookingModel() {
		super();
	}

	public BookingModel(UUID id, LocalDateTime dataInicio, LocalDateTime dataFim, String timeZone, double preco,
			LocalDateTime dataInclusao, LocalDateTime dataModificacao) {
		super();
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.timeZone = timeZone;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDateTime dataFim) {
		this.dataFim = dataFim;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
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
	
	public SpaceModel getEspaco() {
		return espaco;
	}

	public void setEspaco(SpaceModel espaco) {
		this.espaco = espaco;
	}

	public UserModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UserModel usuario) {
		this.usuario = usuario;
	}

	public ReviewModel getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(ReviewModel avaliacao) {
		this.avaliacao = avaliacao;
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
		BookingModel other = (BookingModel) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "BookingModel [id=" + id + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", timeZone="
				+ timeZone + ", preco=" + preco + ", dataInclusao=" + dataInclusao + ", dataModificacao="
				+ dataModificacao + "]";
	}
	
}