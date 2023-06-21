package com.api.project.locus.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.project.locus.dtos.SpaceDto;
import com.api.project.locus.models.AddressModel;
import com.api.project.locus.models.CompanyModel;
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
		Optional<AddressModel> addressModel = addressService.findById(spaceDto.getEnderecoId());
		Optional<CompanyModel> companyModel = companyService.findById(spaceDto.getEmpresaId());
		spaceModel.setEndereco(addressModel.get());
		spaceModel.setEmpresa(companyModel.get());
		return spaceModel;				
	}

}
