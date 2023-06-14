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

import com.api.project.locus.dtos.AddressDto;
import com.api.project.locus.models.AddressModel;
import com.api.project.locus.services.AddressService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/address")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@PostMapping
	public ResponseEntity<Object> saveAddress(@RequestBody @Valid AddressDto addressDto){
		var addressModel = new AddressModel();
		BeanUtils.copyProperties(addressDto, addressModel);
		addressService.setDefaults(addressModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(addressService.save(addressModel));
	}
	
	@GetMapping
	public ResponseEntity<List<AddressModel>> getAllAddresss(){
		return ResponseEntity.status(HttpStatus.OK).body(addressService.findAll());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneAddress(@PathVariable(value = "id") UUID id){
		Optional<AddressModel> AddressModelOptional = addressService.findById(id);
		if (!AddressModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado!");
		}		
		return ResponseEntity.status(HttpStatus.OK).body(AddressModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAddress(@PathVariable(value = "id") UUID id){
		Optional<AddressModel> addressModelOptional = addressService.findById(id);
		if (!addressModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado!");
		}
		addressService.delete(addressModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Endereço deletado!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateAddress(@PathVariable(value = "id") UUID id, 
											    @RequestBody @Valid AddressDto addressDto){
		Optional<AddressModel> addressModelOptional = addressService.findById(id);
		if (!addressModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado!");
		}
		var addressModel = new AddressModel();
		BeanUtils.copyProperties(addressDto, addressModel);
		addressModel.setId(addressModelOptional.get().getId());
		addressModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.OK).body(addressService.save(addressModel));
	}
	
	

}
