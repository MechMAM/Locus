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

import com.api.project.locus.dtos.ChargingMethodDto;
import com.api.project.locus.models.ChargingMethodModel;
import com.api.project.locus.services.ChargingMethodService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/charging-method")
public class ChargingMethodController {
	
	@Autowired
	ChargingMethodService chargingMethodService;
	
	@PostMapping
	public ResponseEntity<Object> saveChargingMethod(@RequestBody @Valid ChargingMethodDto chargingMethodDto){
		var chargingMethodModel = new ChargingMethodModel();
		chargingMethodService.convertDtoToEntity(chargingMethodDto, chargingMethodModel);
		chargingMethodService.setDefaults(chargingMethodModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(chargingMethodService.save(chargingMethodModel));
	}
	
	@GetMapping
	public ResponseEntity<List<ChargingMethodModel>> getAllChargingMethods(){
		return ResponseEntity.status(HttpStatus.OK).body(chargingMethodService.findAll());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneChargingMethod(@PathVariable(value = "id") UUID id){
		Optional<ChargingMethodModel> ChargingMethodModelOptional = chargingMethodService.findById(id);
		if (!ChargingMethodModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Método de cobrança não encontrado!");
		}		
		return ResponseEntity.status(HttpStatus.OK).body(ChargingMethodModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteChargingMethod(@PathVariable(value = "id") UUID id){
		Optional<ChargingMethodModel> chargingMethodModelOptional = chargingMethodService.findById(id);
		if (!chargingMethodModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Método de cobrança não encontrado!");
		}
		chargingMethodService.delete(chargingMethodModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Método de cobrança deletado!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateChargingMethod(@PathVariable(value = "id") UUID id, 
											    @RequestBody @Valid ChargingMethodDto chargingMethodDto){
		Optional<ChargingMethodModel> chargingMethodModelOptional = chargingMethodService.findById(id);
		if (!chargingMethodModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Método de cobrança não encontrado!");
		}
		var chargingMethodModel = new ChargingMethodModel();
		BeanUtils.copyProperties(chargingMethodDto, chargingMethodModel);
		chargingMethodModel.setId(chargingMethodModelOptional.get().getId());
		chargingMethodModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.OK).body(chargingMethodService.save(chargingMethodModel));
	}
	
	

}
