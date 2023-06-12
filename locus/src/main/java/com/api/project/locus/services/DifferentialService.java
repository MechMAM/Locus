package com.api.project.locus.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.project.locus.models.DifferentialModel;
import com.api.project.locus.repositories.DifferentialRepository;

import jakarta.transaction.Transactional;

@Service
public class DifferentialService {
	
	@Autowired
	DifferentialRepository differentialRepository;
	
	@Transactional
	public DifferentialModel save(DifferentialModel differentialModel) {
		return differentialRepository.save(differentialModel);
	}
	
	public List<DifferentialModel> findAll() {		
		return differentialRepository.findAll();
	}
	
	public Optional<DifferentialModel> findById(UUID id) {
		return differentialRepository.findById(id);
	}

	@Transactional
	public void delete(DifferentialModel differentialModel) {
		differentialRepository.delete(differentialModel);;		
	}

	public void setDefaults(DifferentialModel differentialModel) {
		differentialModel.setDataInclusao(LocalDateTime.now(ZoneId.of("UTC")));
		differentialModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
	}

}
