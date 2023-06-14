package com.api.project.locus.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.project.locus.models.ParkingModel;
import com.api.project.locus.repositories.ParkingRepository;

import jakarta.transaction.Transactional;

@Service
public class ParkingService {
	
	@Autowired
	ParkingRepository parkingRepository;
	
	@Transactional
	public ParkingModel save(ParkingModel parkingModel) {
		return parkingRepository.save(parkingModel);
	}
	
	public List<ParkingModel> findAll() {		
		return parkingRepository.findAll();
	}
	
	public Optional<ParkingModel> findById(UUID id) {
		return parkingRepository.findById(id);
	}

	@Transactional
	public void delete(ParkingModel parkingModel) {
		parkingRepository.delete(parkingModel);;		
	}

	public void setDefaults(ParkingModel parkingModel) {
		parkingModel.setDataInclusao(LocalDateTime.now(ZoneId.of("UTC")));
		parkingModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
		parkingModel.setStatus(true);
	}

}
