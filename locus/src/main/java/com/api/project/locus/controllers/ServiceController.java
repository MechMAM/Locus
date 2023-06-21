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

import com.api.project.locus.dtos.ServiceDto;
import com.api.project.locus.models.ServiceModel;
import com.api.project.locus.services.ServiceService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/service")
public class ServiceController {
	
	@Autowired
	ServiceService serviceService;
	
	@PostMapping
	public ResponseEntity<Object> saveService(@RequestBody @Valid ServiceDto serviceDto){
		var serviceModel = new ServiceModel();
		BeanUtils.copyProperties(serviceDto, serviceModel);
		serviceService.setDefaults(serviceModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceService.save(serviceModel));
	}
	
	@GetMapping
	public ResponseEntity<List<ServiceModel>> getAllServices(){
		return ResponseEntity.status(HttpStatus.OK).body(serviceService.findAll());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneService(@PathVariable(value = "id") UUID id){
		Optional<ServiceModel> ServiceModelOptional = serviceService.findById(id);
		if (!ServiceModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Serviço não encontrado!");
		}		
		return ResponseEntity.status(HttpStatus.OK).body(ServiceModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteService(@PathVariable(value = "id") UUID id){
		Optional<ServiceModel> serviceModelOptional = serviceService.findById(id);
		if (!serviceModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Serviço não encontrado!");
		}
		serviceService.delete(serviceModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Serviço deletado!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateService(@PathVariable(value = "id") UUID id, 
											    @RequestBody @Valid ServiceDto serviceDto){
		Optional<ServiceModel> serviceModelOptional = serviceService.findById(id);
		if (!serviceModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Serviço não encontrado!");
		}
		var serviceModel = new ServiceModel();
		BeanUtils.copyProperties(serviceDto, serviceModel);
		serviceModel.setId(serviceModelOptional.get().getId());
		serviceModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.OK).body(serviceService.save(serviceModel));
	}
	
	

}
