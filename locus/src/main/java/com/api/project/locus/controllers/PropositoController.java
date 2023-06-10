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

import com.api.project.locus.dtos.PurposeDto;
import com.api.project.locus.models.PurposeModel;
import com.api.project.locus.services.PurposeService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/purpose")
public class PropositoController {
	
	@Autowired
	PurposeService purposeService;
	
	@PostMapping
	public ResponseEntity<Object> savePurpose(@RequestBody @Valid PurposeDto purposeDto){
		var purposeModel = new PurposeModel();
		BeanUtils.copyProperties(purposeDto, purposeModel);
		purposeService.setDefaults(purposeModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(purposeService.save(purposeModel));
	}
	
	@GetMapping
	public ResponseEntity<List<PurposeModel>> getAllPurposes(){
		return ResponseEntity.status(HttpStatus.OK).body(purposeService.findAll());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOnePurpose(@PathVariable(value = "id") UUID id){
		Optional<PurposeModel> PurposeModelOptional = purposeService.findById(id);
		if (!PurposeModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
		}		
		return ResponseEntity.status(HttpStatus.OK).body(PurposeModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePurpose(@PathVariable(value = "id") UUID id){
		Optional<PurposeModel> purposeModelOptional = purposeService.findById(id);
		if (!purposeModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
		}
		purposeService.delete(purposeModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePurpose(@PathVariable(value = "id") UUID id, 
											    @RequestBody @Valid PurposeDto purposeDto){
		Optional<PurposeModel> purposeModelOptional = purposeService.findById(id);
		if (!purposeModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
		}
		var purposeModel = new PurposeModel();
		BeanUtils.copyProperties(purposeDto, purposeModel);
		purposeModel.setId(purposeModelOptional.get().getId());
		purposeModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.OK).body(purposeService.save(purposeModel));
	}
	
	

}
