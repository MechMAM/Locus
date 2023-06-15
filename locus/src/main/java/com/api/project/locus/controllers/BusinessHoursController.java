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

import com.api.project.locus.dtos.BusinessHoursDto;
import com.api.project.locus.models.BusinessHoursModel;
import com.api.project.locus.services.BusinessHoursService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/businessHours")
public class BusinessHoursController {
	
	@Autowired
	BusinessHoursService businessHoursService;
	
	@PostMapping
	public ResponseEntity<Object> saveBusinessHours(@RequestBody @Valid BusinessHoursDto businessHoursDto){
		var businessHoursModel = new BusinessHoursModel();
		BeanUtils.copyProperties(businessHoursDto, businessHoursModel);
		businessHoursService.setDefaults(businessHoursModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(businessHoursService.save(businessHoursModel));
	}
	
	@GetMapping
	public ResponseEntity<List<BusinessHoursModel>> getAllBusinessHourss(){
		return ResponseEntity.status(HttpStatus.OK).body(businessHoursService.findAll());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneBusinessHours(@PathVariable(value = "id") UUID id){
		Optional<BusinessHoursModel> BusinessHoursModelOptional = businessHoursService.findById(id);
		if (!BusinessHoursModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Horário de Atendimento não encontrado!");
		}		
		return ResponseEntity.status(HttpStatus.OK).body(BusinessHoursModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteBusinessHours(@PathVariable(value = "id") UUID id){
		Optional<BusinessHoursModel> businessHoursModelOptional = businessHoursService.findById(id);
		if (!businessHoursModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Horário de Atendimento não encontrado!");
		}
		businessHoursService.delete(businessHoursModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Horário de Atendimento deletado!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateBusinessHours(@PathVariable(value = "id") UUID id, 
											    @RequestBody @Valid BusinessHoursDto businessHoursDto){
		Optional<BusinessHoursModel> businessHoursModelOptional = businessHoursService.findById(id);
		if (!businessHoursModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Horário de Atendimento não encontrado!");
		}
		var businessHoursModel = new BusinessHoursModel();
		BeanUtils.copyProperties(businessHoursDto, businessHoursModel);
		businessHoursModel.setId(businessHoursModelOptional.get().getId());
		businessHoursModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.OK).body(businessHoursService.save(businessHoursModel));
	}
	
	

}
