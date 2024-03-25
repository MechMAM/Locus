package com.api.project.locus.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.project.locus.models.PurposeModel;
import com.api.project.locus.repositories.PurposeRepository;

import jakarta.transaction.Transactional;

@Service
public class PurposeService {
	
	@Autowired
	PurposeRepository purposeRepository;
	
	@Transactional
	public PurposeModel save(PurposeModel purposeModel) {
		return purposeRepository.save(purposeModel);
	}
	
	public List<PurposeModel> findAll() {		
		return purposeRepository.findAll();
	}
	
	public Optional<PurposeModel> findById(UUID id) {
		return purposeRepository.findById(id);
	}

	@Transactional
	public void delete(PurposeModel purposeModel) {
		purposeRepository.delete(purposeModel);;		
	}

	public void setDefaults(PurposeModel purposeModel) {
		purposeModel.setDataInclusao(LocalDateTime.now(ZoneId.of("UTC")));
		purposeModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
		purposeModel.setStatus(true);
	}

}
