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

import com.api.project.locus.dtos.DifferentialDto;
import com.api.project.locus.models.DifferentialModel;
import com.api.project.locus.services.DifferentialService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/differential")
public class DifferentialController {
	
	@Autowired
	DifferentialService differentialService;
	
	@PostMapping
	public ResponseEntity<Object> saveDifferential(@RequestBody @Valid DifferentialDto differentialDto){
		var differentialModel = new DifferentialModel();
		BeanUtils.copyProperties(differentialDto, differentialModel);
		differentialService.setDefaults(differentialModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(differentialService.save(differentialModel));
	}
	
	@GetMapping
	public ResponseEntity<List<DifferentialModel>> getAllDifferentials(){
		return ResponseEntity.status(HttpStatus.OK).body(differentialService.findAll());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneDifferential(@PathVariable(value = "id") UUID id){
		Optional<DifferentialModel> DifferentialModelOptional = differentialService.findById(id);
		if (!DifferentialModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Diferencial não encontrado!");
		}		
		return ResponseEntity.status(HttpStatus.OK).body(DifferentialModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteDifferential(@PathVariable(value = "id") UUID id){
		Optional<DifferentialModel> differentialModelOptional = differentialService.findById(id);
		if (!differentialModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Diferencial não encontrado!");
		}
		differentialService.delete(differentialModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Diferencial deletado!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateDifferential(@PathVariable(value = "id") UUID id, 
											    @RequestBody @Valid DifferentialDto differentialDto){
		Optional<DifferentialModel> differentialModelOptional = differentialService.findById(id);
		if (!differentialModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Diferencial não encontrado!");
		}
		var differentialModel = new DifferentialModel();
		BeanUtils.copyProperties(differentialDto, differentialModel);
		differentialModel.setId(differentialModelOptional.get().getId());
		differentialModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.OK).body(differentialService.save(differentialModel));
	}
	
	

}
