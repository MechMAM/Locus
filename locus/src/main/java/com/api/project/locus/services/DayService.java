package com.api.project.locus.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.project.locus.models.DayModel;
import com.api.project.locus.repositories.DayRepository;

import jakarta.transaction.Transactional;

@Service
public class DayService {
	
	@Autowired
	DayRepository dayRepository;
	
	@Transactional
	public DayModel save(DayModel dayModel) {
		return dayRepository.save(dayModel);
	}
	
	public List<DayModel> findAll() {		
		return dayRepository.findAll();
	}
	
	public Optional<DayModel> findById(UUID id) {
		return dayRepository.findById(id);
	}

	@Transactional
	public void delete(DayModel dayModel) {
		dayRepository.delete(dayModel);;		
	}

	public void setDefaults(DayModel dayModel) {
		dayModel.setDataInclusao(LocalDateTime.now(ZoneId.of("UTC")));
		dayModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
	}

}
