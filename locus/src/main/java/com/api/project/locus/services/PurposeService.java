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
	PurposeRepository propositoRepository;
	
	@Transactional
	public PurposeModel save(PurposeModel propositoModel) {
		return propositoRepository.save(propositoModel);
	}
	
	public List<PurposeModel> findAll() {		
		return propositoRepository.findAll();
	}
	
	public Optional<PurposeModel> findById(UUID id) {
		return propositoRepository.findById(id);
	}

	@Transactional
	public void delete(PurposeModel propositoModel) {
		propositoRepository.delete(propositoModel);;		
	}

	public void setDefaults(PurposeModel purposeModel) {
		purposeModel.setDataInclusao(LocalDateTime.now(ZoneId.of("UTC")));
		purposeModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
		purposeModel.setStatus(true);
	}

}
