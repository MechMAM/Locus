package com.api.project.locus.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.project.locus.models.ServiceModel;
import com.api.project.locus.repositories.ServiceRepository;

import jakarta.transaction.Transactional;

@Service
public class ServiceService {
	
	@Autowired
	ServiceRepository serviceRepository;
	
	@Transactional
	public ServiceModel save(ServiceModel serviceModel) {
		return serviceRepository.save(serviceModel);
	}
	
	public List<ServiceModel> findAll() {		
		return serviceRepository.findAll();
	}
	
	public Optional<ServiceModel> findById(UUID id) {
		return serviceRepository.findById(id);
	}

	@Transactional
	public void delete(ServiceModel serviceModel) {
		serviceRepository.delete(serviceModel);;		
	}

	public void setDefaults(ServiceModel serviceModel) {
		serviceModel.setDataInclusao(LocalDateTime.now(ZoneId.of("UTC")));
		serviceModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
	}

}
