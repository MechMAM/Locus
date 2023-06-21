package com.api.project.locus.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.project.locus.dtos.ParkingDto;
import com.api.project.locus.models.ParkingModel;
import com.api.project.locus.services.ParkingService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/parking")
public class ParkingController {
	
	@Autowired
	ParkingService parkingService;
	
	@PostMapping
	public ResponseEntity<Object> saveParking(@RequestBody @Valid ParkingDto parkingDto){
		var parkingModel = new ParkingModel();
		parkingService.convertDtoToEntity(parkingDto, parkingModel);
		parkingService.setDefaults(parkingModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(parkingService.save(parkingModel));
	}
	
	@GetMapping
	public ResponseEntity<List<ParkingModel>> getAllParkings(){
		return ResponseEntity.status(HttpStatus.OK).body(parkingService.findAll());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneParking(@PathVariable(value = "id") UUID id){
		Optional<ParkingModel> ParkingModelOptional = parkingService.findById(id);
		if (!ParkingModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estacionamento não encontrado!");
		}		
		return ResponseEntity.status(HttpStatus.OK).body(ParkingModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteParking(@PathVariable(value = "id") UUID id){
		Optional<ParkingModel> parkingModelOptional = parkingService.findById(id);
		if (!parkingModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estacionamento não encontrado!");
		}
		parkingService.delete(parkingModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Estacionamento deletado!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateParking(@PathVariable(value = "id") UUID id, 
											    @RequestBody @Valid ParkingDto parkingDto){
		Optional<ParkingModel> parkingModelOptional = parkingService.findById(id);
		if (!parkingModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estacionamento não encontrado!");
		}
		var parkingModel = new ParkingModel();
		BeanUtils.copyProperties(parkingDto, parkingModel);
		parkingModel.setId(parkingModelOptional.get().getId());
		parkingModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.OK).body(parkingService.save(parkingModel));
	}	
}
