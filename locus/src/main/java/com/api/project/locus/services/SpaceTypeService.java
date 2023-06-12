package com.api.project.locus.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.project.locus.models.SpaceTypeModel;
import com.api.project.locus.repositories.SpaceTypeRepository;

import jakarta.transaction.Transactional;

@Service
public class SpaceTypeService {
	
	@Autowired
	SpaceTypeRepository spaceTypeRepository;
	
	@Transactional
	public SpaceTypeModel save(SpaceTypeModel spaceTypeModel) {
		return spaceTypeRepository.save(spaceTypeModel);
	}
	
	public List<SpaceTypeModel> findAll() {		
		return spaceTypeRepository.findAll();
	}
	
	public Optional<SpaceTypeModel> findById(UUID id) {
		return spaceTypeRepository.findById(id);
	}

	@Transactional
	public void delete(SpaceTypeModel spaceTypeModel) {
		spaceTypeRepository.delete(spaceTypeModel);;		
	}

	public void setDefaults(SpaceTypeModel spaceTypeModel) {
		spaceTypeModel.setDataInclusao(LocalDateTime.now(ZoneId.of("UTC")));
		spaceTypeModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
	}

}
