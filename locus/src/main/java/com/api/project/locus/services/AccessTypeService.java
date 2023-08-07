package com.api.project.locus.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.project.locus.models.AccessTypeModel;
import com.api.project.locus.repositories.AccessTypeRepository;

import jakarta.transaction.Transactional;

@Service
public class AccessTypeService {
	
	@Autowired
	AccessTypeRepository accessTypeRepository;
	
	@Transactional
	public AccessTypeModel save(AccessTypeModel accessTypeModel) {
		return accessTypeRepository.save(accessTypeModel);
	}
	
	public List<AccessTypeModel> findAll() {		
		return accessTypeRepository.findAll();
	}
	
	public Optional<AccessTypeModel> findById(UUID id) {
		return accessTypeRepository.findById(id);
	}

	@Transactional
	public void delete(AccessTypeModel accessTypeModel) {
		accessTypeRepository.delete(accessTypeModel);;		
	}

	public void setDefaults(AccessTypeModel accessTypeModel) {
		accessTypeModel.setDataInclusao(LocalDateTime.now(ZoneId.of("UTC")));
		accessTypeModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
		accessTypeModel.setStatus(true);
	}

}
