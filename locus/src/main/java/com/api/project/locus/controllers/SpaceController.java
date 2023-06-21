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

import com.api.project.locus.dtos.SpaceDto;
import com.api.project.locus.models.SpaceModel;
import com.api.project.locus.services.SpaceService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/space")
public class SpaceController {
	
	@Autowired
	SpaceService spaceService;
	
	@PostMapping()
	public ResponseEntity<Object> saveSpace(@RequestBody @Valid SpaceDto spaceDto){
		var spaceModel = new SpaceModel();
		spaceModel = spaceService.convertToEntity(spaceDto);
		spaceService.setDefaults(spaceModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(spaceService.save(spaceModel));
	}
	
	@GetMapping
	public ResponseEntity<List<SpaceModel>> getAllSpaces(){
		return ResponseEntity.status(HttpStatus.OK).body(spaceService.findAll());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneSpace(@PathVariable(value = "id") UUID id){
		Optional<SpaceModel> SpaceModelOptional = spaceService.findById(id);
		if (!SpaceModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Espaço não encontrado!");
		}		
		return ResponseEntity.status(HttpStatus.OK).body(SpaceModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteSpace(@PathVariable(value = "id") UUID id){
		Optional<SpaceModel> spaceModelOptional = spaceService.findById(id);
		if (!spaceModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Espaço não encontrado!");
		}
		spaceService.delete(spaceModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Espaço deletado!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateSpace(@PathVariable(value = "id") UUID id, 
											    @RequestBody @Valid SpaceDto spaceDto){
		Optional<SpaceModel> spaceModelOptional = spaceService.findById(id);
		if (!spaceModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Espaço não encontrado!");
		}
		var spaceModel = new SpaceModel();
		BeanUtils.copyProperties(spaceDto, spaceModel);
		spaceModel.setId(spaceModelOptional.get().getId());
		spaceModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.OK).body(spaceService.save(spaceModel));
	}
	
	

}
