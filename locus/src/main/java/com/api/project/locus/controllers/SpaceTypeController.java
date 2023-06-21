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

import com.api.project.locus.dtos.SpaceTypeDto;
import com.api.project.locus.models.SpaceTypeModel;
import com.api.project.locus.services.SpaceTypeService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/spaceType")
public class SpaceTypeController {
	
	@Autowired
	SpaceTypeService spaceTypeService;
	
	@PostMapping
	public ResponseEntity<Object> saveSpaceType(@RequestBody @Valid SpaceTypeDto spaceTypeDto){
		var spaceTypeModel = new SpaceTypeModel();
		BeanUtils.copyProperties(spaceTypeDto, spaceTypeModel);
		spaceTypeService.setDefaults(spaceTypeModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(spaceTypeService.save(spaceTypeModel));
	}
	
	@GetMapping
	public ResponseEntity<List<SpaceTypeModel>> getAllSpaceTypes(){
		return ResponseEntity.status(HttpStatus.OK).body(spaceTypeService.findAll());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneSpaceType(@PathVariable(value = "id") UUID id){
		Optional<SpaceTypeModel> SpaceTypeModelOptional = spaceTypeService.findById(id);
		if (!SpaceTypeModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de Espaço não encontrado!");
		}		
		return ResponseEntity.status(HttpStatus.OK).body(SpaceTypeModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteSpaceType(@PathVariable(value = "id") UUID id){
		Optional<SpaceTypeModel> spaceTypeModelOptional = spaceTypeService.findById(id);
		if (!spaceTypeModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de Espaço não encontrado!");
		}
		spaceTypeService.delete(spaceTypeModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Tipo de Espaço deletado!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateSpaceType(@PathVariable(value = "id") UUID id, 
											    @RequestBody @Valid SpaceTypeDto spaceTypeDto){
		Optional<SpaceTypeModel> spaceTypeModelOptional = spaceTypeService.findById(id);
		if (!spaceTypeModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de Espaço não encontrado!");
		}
		var spaceTypeModel = new SpaceTypeModel();
		BeanUtils.copyProperties(spaceTypeDto, spaceTypeModel);
		spaceTypeModel.setId(spaceTypeModelOptional.get().getId());
		spaceTypeModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.OK).body(spaceTypeService.save(spaceTypeModel));
	}
	
	

}
