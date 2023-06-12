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

import com.api.project.locus.dtos.AccessibilityDto;
import com.api.project.locus.models.AccessibilityModel;
import com.api.project.locus.services.AccessibilityService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/accessibility")
public class AccessibilityController {
	
	@Autowired
	AccessibilityService accessibilityService;
	
	@PostMapping
	public ResponseEntity<Object> saveAccessibility(@RequestBody @Valid AccessibilityDto accessibilityDto){
		var accessibilityModel = new AccessibilityModel();
		BeanUtils.copyProperties(accessibilityDto, accessibilityModel);
		accessibilityService.setDefaults(accessibilityModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(accessibilityService.save(accessibilityModel));
	}
	
	@GetMapping
	public ResponseEntity<List<AccessibilityModel>> getAllAccessibilitys(){
		return ResponseEntity.status(HttpStatus.OK).body(accessibilityService.findAll());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneAccessibility(@PathVariable(value = "id") UUID id){
		Optional<AccessibilityModel> AccessibilityModelOptional = accessibilityService.findById(id);
		if (!AccessibilityModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Acessibilidade não encontrada!");
		}		
		return ResponseEntity.status(HttpStatus.OK).body(AccessibilityModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAccessibility(@PathVariable(value = "id") UUID id){
		Optional<AccessibilityModel> accessibilityModelOptional = accessibilityService.findById(id);
		if (!accessibilityModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Acessibilidade não encontrada!");
		}
		accessibilityService.delete(accessibilityModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Acessibilidade deletada!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateAccessibility(@PathVariable(value = "id") UUID id, 
											    @RequestBody @Valid AccessibilityDto accessibilityDto){
		Optional<AccessibilityModel> accessibilityModelOptional = accessibilityService.findById(id);
		if (!accessibilityModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Acessibilidade não encontrada!");
		}
		var accessibilityModel = new AccessibilityModel();
		BeanUtils.copyProperties(accessibilityDto, accessibilityModel);
		accessibilityModel.setId(accessibilityModelOptional.get().getId());
		accessibilityModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.OK).body(accessibilityService.save(accessibilityModel));
	}
	
	

}
