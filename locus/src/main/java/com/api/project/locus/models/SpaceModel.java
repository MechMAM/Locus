package com.api.project.locus.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Espaco")
public class SpaceModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false, columnDefinition = "TEXT")
	private String descricao;
	@Column(columnDefinition = "TEXT")
	private String descricaoArredores;
	@Column(nullable = false)
	private int capacidade;
	@Column(nullable = false)
	private double area;
	@Column
	private LocalTime tempoLimpeza;
	@Column
	private double taxaLimpeza;
	@Column(nullable = false)
	private boolean hasTaxaLimpeza;
	@Column(nullable = false)
	private double precoHorario;
	@Column
	private LocalDateTime dataInclusao;
	@Column
	private LocalDateTime dataModificacao;
	@Column
	private boolean status;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_endereco_id", nullable = false)
	private AddressModel endereco;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_empresa_id", nullable = false)
	@JsonIgnore
	private CompanyModel empresa;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "espaco")
	private Set<BusinessHoursModel> disponibilidade = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "espaco")
	private Set<ImageModel> imagens = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "espaco")
	private Set<ParkingModel> estacionamentos = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "espaco")
	private Set<SpaceHasServiceModel> servicos = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
					})
	@JoinTable(
			  name = "espaco_has_acessibilidade", 
			  joinColumns = @JoinColumn(name = "espaco_id", referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "acessibilidade_id", referencedColumnName = "id"))
	private Set<AccessibilityModel> acessibilidades = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
					})
	@JoinTable(
			  name = "espaco_has_proposito", 
			  joinColumns = @JoinColumn(name = "espaco_id", referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "proposito_id", referencedColumnName = "id"))
	private Set<PurposeModel> propositos = new HashSet<>();;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
					})
	@JoinTable(
			  name = "espaco_has_tipo_espaco", 
			  joinColumns = @JoinColumn(name = "espaco_id", referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "tipo_espaco_id", referencedColumnName = "id"))
	private Set<SpaceTypeModel> tiposDoEspaco = new HashSet<>();;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
					})
	@JoinTable(
			  name = "espaco_has_diferencial", 
			  joinColumns = @JoinColumn(name = "espaco_id", referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "diferenciais_id", referencedColumnName = "id"))
	private Set<DifferentialModel> diferenciais = new HashSet<>();;
	
	public SpaceModel() {
		super();
	}

	public SpaceModel(UUID id, String nome, String descricao, String descricaoArredores, int capacidade, double area,
			LocalTime tempoLimpeza, double taxaLimpeza, boolean hasTaxaLimpeza, double precoHorario,
			LocalDateTime dataInclusao, LocalDateTime dataModificacao, boolean status) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.descricaoArredores = descricaoArredores;
		this.capacidade = capacidade;
		this.area = area;
		this.tempoLimpeza = tempoLimpeza;
		this.taxaLimpeza = taxaLimpeza;
		this.hasTaxaLimpeza = hasTaxaLimpeza;
		this.precoHorario = precoHorario;
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

	public String getDescricaoArredores() {
		return descricaoArredores;
	}

	public void setDescricaoArredores(String descricaoArredores) {
		this.descricaoArredores = descricaoArredores;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public LocalTime getTempoLimpeza() {
		return tempoLimpeza;
	}

	public void setTempoLimpeza(LocalTime tempoLimpeza) {
		this.tempoLimpeza = tempoLimpeza;
	}

	public double getTaxaLimpeza() {
		return taxaLimpeza;
	}

	public void setTaxaLimpeza(double taxaLimpeza) {
		this.taxaLimpeza = taxaLimpeza;
	}

	public boolean isHasTaxaLimpeza() {
		return hasTaxaLimpeza;
	}

	public void setHasTaxaLimpeza(boolean hasTaxaLimpeza) {
		this.hasTaxaLimpeza = hasTaxaLimpeza;
	}

	public double getPrecoHorario() {
		return precoHorario;
	}

	public void setPrecoHorario(double precoHorario) {
		this.precoHorario = precoHorario;
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

	public AddressModel getEndereco() {
		return endereco;
	}

	public void setEndereco(AddressModel endereco) {
		this.endereco = endereco;
	}

	public CompanyModel getEmpresa() {
		return empresa;
	}

	public void setEmpresa(CompanyModel empresa) {
		this.empresa = empresa;
	}

	public Set<BusinessHoursModel> getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(Set<BusinessHoursModel> disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public Set<SpaceHasServiceModel> getServicos() {
		return servicos;
	}

	public void setServicos(Set<SpaceHasServiceModel> servicos) {
		this.servicos = servicos;
	}

	public Set<ImageModel> getImagens() {
		return imagens;
	}

	public void setImagens(Set<ImageModel> imagens) {
		this.imagens = imagens;
	}

	public Set<ParkingModel> getEstacionamentos() {
		return estacionamentos;
	}

	public void setEstacionamentos(Set<ParkingModel> estacionamentos) {
		this.estacionamentos = estacionamentos;
	}

	public Set<AccessibilityModel> getAcessibilidades() {
		return acessibilidades;
	}

	public void setAcessibilidades(Set<AccessibilityModel> acessibilidades) {
		this.acessibilidades = acessibilidades;
	}

	public Set<PurposeModel> getPropositos() {
		return propositos;
	}

	public void setPropositos(Set<PurposeModel> propositos) {
		this.propositos = propositos;
	}

	public Set<SpaceTypeModel> getTiposDoEspaco() {
		return tiposDoEspaco;
	}

	public void setTiposDoEspaco(Set<SpaceTypeModel> tiposDoEspaco) {
		this.tiposDoEspaco = tiposDoEspaco;
	}

	public Set<DifferentialModel> getDiferenciais() {
		return diferenciais;
	}

	public void setDiferenciais(Set<DifferentialModel> diferenciais) {
		this.diferenciais = diferenciais;
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
		SpaceModel other = (SpaceModel) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "SpaceModel [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", descricaoArredores="
				+ descricaoArredores + ", capacidade=" + capacidade + ", area=" + area + ", tempoLimpeza="
				+ tempoLimpeza + ", taxaLimpeza=" + taxaLimpeza + ", hasTaxaLimpeza=" + hasTaxaLimpeza
				+ ", precoHorario=" + precoHorario + ", dataInclusao=" + dataInclusao + ", dataModificacao="
				+ dataModificacao + ", status=" + status + ", endereco=" + endereco + ", empresa=" + empresa
				+ ", disponibilidade=" + disponibilidade + "]";
	}
	
	
	
}
