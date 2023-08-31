package com.api.project.locus.services;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.project.locus.dtos.SpaceDto;
import com.api.project.locus.models.AccessibilityModel;
import com.api.project.locus.models.AddressModel;
import com.api.project.locus.models.CompanyModel;
import com.api.project.locus.models.DifferentialModel;
import com.api.project.locus.models.PurposeModel;
import com.api.project.locus.models.SpaceModel;
import com.api.project.locus.repositories.SpaceRepository;

import jakarta.transaction.Transactional;

@Service
public class SpaceService {
	
	@Autowired
	SpaceRepository spaceRepository;
	@Autowired
	AddressService addressService;
	@Autowired
	CompanyService companyService;
	@Autowired
	PurposeService purposeService;
	@Autowired
	DifferentialService differentialService;
	@Autowired
	AccessibilityService accessibilityService;
	
	@Transactional
	public SpaceModel save(SpaceModel spaceModel) {
		return spaceRepository.save(spaceModel);
	}
	
	public List<SpaceModel> findAll() {		
		return spaceRepository.findAll();
	}
	
	public Optional<SpaceModel> findById(UUID id) {
		return spaceRepository.findById(id);
	}

	@Transactional
	public void delete(SpaceModel spaceModel) {
		spaceRepository.delete(spaceModel);;		
	}

	public void setDefaults(SpaceModel purposeModel) {
		purposeModel.setDataInclusao(LocalDateTime.now(ZoneId.of("UTC")));
		purposeModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
		purposeModel.setStatus(true);
	}

	public SpaceModel convertToEntity(SpaceDto spaceDto) {
		SpaceModel spaceModel = new SpaceModel();
		BeanUtils.copyProperties(spaceDto, spaceModel);
		setEndereco(spaceDto.getEnderecoId(), spaceModel);
		setEmpresa(spaceDto.getEmpresaId(),spaceModel);
		setDiferenciais(spaceDto.getDiferenciais(), spaceModel);
		setAcessibilidades(spaceDto.getAcessibilidades(), spaceModel);
		setPropositos(spaceDto.getPropositos(), spaceModel);
		return spaceModel;				
	}
	
	public double evaluatePrice(LocalDateTime dataInicio, LocalDateTime dataFim, double precoHorario, double taxaLimpeza) {
		Duration duracao = Duration.between(dataInicio, dataFim);
		double precoReserva = duracao.getSeconds()/3600*precoHorario+taxaLimpeza;
		return precoReserva;
	}
	
	private void setPropositos(Set<UUID> propositos, SpaceModel spaceModel) {
		propositos.forEach(propositoId -> {
			Optional<PurposeModel> purposeModel = purposeService.findById(propositoId);
			spaceModel.getPropositos().add(purposeModel.get());
		});
	}

	private void setAcessibilidades(Set<UUID> acessibilidades, SpaceModel spaceModel) {
		acessibilidades.forEach(acessibilidadeId -> {
			Optional<AccessibilityModel> accessibilityModel = accessibilityService.findById(acessibilidadeId);
			spaceModel.getAcessibilidades().add(accessibilityModel.get());
		});
	}

	private void setDiferenciais(Set<UUID> diferenciais, SpaceModel spaceModel) {
		diferenciais.forEach(diferencialId -> {
			Optional<DifferentialModel> differentialModel = differentialService.findById(diferencialId);
			spaceModel.getDiferenciais().add(differentialModel.get());
		});
	}

	private void setEndereco(UUID adressId, SpaceModel spaceModel) {
		Optional<AddressModel> addressModel = addressService.findById(adressId);
		spaceModel.setEndereco(addressModel.get());
	}
	
	private void setEmpresa(UUID companyId, SpaceModel spaceModel) {
		Optional<CompanyModel> companyModel = companyService.findById(companyId);
		spaceModel.setEmpresa(companyModel.get());
	}

}
