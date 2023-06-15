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

import com.api.project.locus.dtos.DayDto;
import com.api.project.locus.models.DayModel;
import com.api.project.locus.services.DayService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/day")
public class DayController {
	
	@Autowired
	DayService dayService;
	
	@PostMapping
	public ResponseEntity<Object> saveDay(@RequestBody @Valid DayDto dayDto){
		var dayModel = new DayModel();
		BeanUtils.copyProperties(dayDto, dayModel);
		dayService.setDefaults(dayModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(dayService.save(dayModel));
	}
	
	@GetMapping
	public ResponseEntity<List<DayModel>> getAllDays(){
		return ResponseEntity.status(HttpStatus.OK).body(dayService.findAll());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneDay(@PathVariable(value = "id") UUID id){
		Optional<DayModel> DayModelOptional = dayService.findById(id);
		if (!DayModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dia da semana não encontrado!");
		}		
		return ResponseEntity.status(HttpStatus.OK).body(DayModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteDay(@PathVariable(value = "id") UUID id){
		Optional<DayModel> dayModelOptional = dayService.findById(id);
		if (!dayModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dia da semana não encontrado!");
		}
		dayService.delete(dayModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Dia da semana deletado!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateDay(@PathVariable(value = "id") UUID id, 
											    @RequestBody @Valid DayDto dayDto){
		Optional<DayModel> dayModelOptional = dayService.findById(id);
		if (!dayModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dia da semana não encontrado!");
		}
		var dayModel = new DayModel();
		BeanUtils.copyProperties(dayDto, dayModel);
		dayModel.setId(dayModelOptional.get().getId());
		dayModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.OK).body(dayService.save(dayModel));
	}
	
	

}
