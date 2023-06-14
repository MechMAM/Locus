package com.api.project.locus.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.project.locus.models.AccessibilityModel;
import com.api.project.locus.repositories.AccessibilityRepository;

import jakarta.transaction.Transactional;

@Service
public class AccessibilityService {
	
	@Autowired
	AccessibilityRepository accessibilityRepository;
	
	@Transactional
	public AccessibilityModel save(AccessibilityModel accessibilityModel) {
		return accessibilityRepository.save(accessibilityModel);
	}
	
	public List<AccessibilityModel> findAll() {		
		return accessibilityRepository.findAll();
	}
	
	public Optional<AccessibilityModel> findById(UUID id) {
		return accessibilityRepository.findById(id);
	}

	@Transactional
	public void delete(AccessibilityModel accessibilityModel) {
		accessibilityRepository.delete(accessibilityModel);;		
	}

	public void setDefaults(AccessibilityModel accessibilityModel) {
		accessibilityModel.setDataInclusao(LocalDateTime.now(ZoneId.of("UTC")));
		accessibilityModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
		accessibilityModel.setStatus(true);
	}

}
