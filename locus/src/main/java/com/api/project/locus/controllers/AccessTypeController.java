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

import com.api.project.locus.dtos.AccessTypeDto;
import com.api.project.locus.models.AccessTypeModel;
import com.api.project.locus.services.AccessTypeService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/accessType")
public class AccessTypeController {
	
	@Autowired
	AccessTypeService accessTypeService;
	
	@PostMapping
	public ResponseEntity<Object> saveAccessType(@RequestBody @Valid AccessTypeDto accessTypeDto){
		var accessTypeModel = new AccessTypeModel();
		BeanUtils.copyProperties(accessTypeDto, accessTypeModel);
		accessTypeService.setDefaults(accessTypeModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(accessTypeService.save(accessTypeModel));
	}
	
	@GetMapping
	public ResponseEntity<List<AccessTypeModel>> getAllAccessTypes(){
		return ResponseEntity.status(HttpStatus.OK).body(accessTypeService.findAll());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneAccessType(@PathVariable(value = "id") UUID id){
		Optional<AccessTypeModel> AccessTypeModelOptional = accessTypeService.findById(id);
		if (!AccessTypeModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de Espaço não encontrado!");
		}		
		return ResponseEntity.status(HttpStatus.OK).body(AccessTypeModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAccessType(@PathVariable(value = "id") UUID id){
		Optional<AccessTypeModel> accessTypeModelOptional = accessTypeService.findById(id);
		if (!accessTypeModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de Espaço não encontrado!");
		}
		accessTypeService.delete(accessTypeModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Tipo de Espaço deletado!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateAccessType(@PathVariable(value = "id") UUID id, 
											    @RequestBody @Valid AccessTypeDto accessTypeDto){
		Optional<AccessTypeModel> accessTypeModelOptional = accessTypeService.findById(id);
		if (!accessTypeModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de Espaço não encontrado!");
		}
		var accessTypeModel = new AccessTypeModel();
		BeanUtils.copyProperties(accessTypeDto, accessTypeModel);
		accessTypeModel.setId(accessTypeModelOptional.get().getId());
		accessTypeModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.OK).body(accessTypeService.save(accessTypeModel));
	}
	
	

}
