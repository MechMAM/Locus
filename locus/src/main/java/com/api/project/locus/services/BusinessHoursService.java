package com.api.project.locus.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.project.locus.dtos.BusinessHoursDto;
import com.api.project.locus.models.BusinessHoursModel;
import com.api.project.locus.models.SpaceModel;
import com.api.project.locus.repositories.BusinessHoursRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class BusinessHoursService {
	
	@Autowired
	BusinessHoursRepository businessHoursRepository;
	
	@Autowired
	SpaceService spaceService;
	
	@Transactional
	public BusinessHoursModel save(BusinessHoursModel businessHoursModel) {
		return businessHoursRepository.save(businessHoursModel);
	}
	
	public List<BusinessHoursModel> findAll() {		
		return businessHoursRepository.findAll();
	}
	
	public Optional<BusinessHoursModel> findById(UUID id) {
		return businessHoursRepository.findById(id);
	}

	@Transactional
	public void delete(BusinessHoursModel businessHoursModel) {
		businessHoursRepository.delete(businessHoursModel);;		
	}

	public void setDefaults(BusinessHoursModel businessHoursModel) {
		businessHoursModel.setDataInclusao(LocalDateTime.now(ZoneId.of("UTC")));
		businessHoursModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
	}

	public void convertDtoToEntity(@Valid BusinessHoursDto businessHoursDto, BusinessHoursModel businessHoursModel) {
		BeanUtils.copyProperties(businessHoursDto, businessHoursModel);
		Optional<SpaceModel> spaceModel = spaceService.findById(businessHoursDto.getEspacoId());
		businessHoursModel.setEspaco(spaceModel.get());				
	}

}
