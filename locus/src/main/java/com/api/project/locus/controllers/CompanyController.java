package com.api.project.locus.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

import com.api.project.locus.dtos.CompanyDto;
import com.api.project.locus.models.CompanyModel;
import com.api.project.locus.services.CompanyService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	@PostMapping
	public ResponseEntity<Object> saveCompany(@RequestBody @Valid CompanyDto companyDto){
		var companyModel = new CompanyModel();
		BeanUtils.copyProperties(companyDto, companyModel);
		companyModel.setCnpj(companyService.cleanCnpj(companyModel.getCnpj()));
		companyModel.setDataCriacao(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(companyService.save(companyModel));
	}
	
	@GetMapping
	public ResponseEntity<Page<CompanyModel>> getAllCompanys(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(companyService.findAll(pageable));
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneCompany(@PathVariable(value = "id") UUID id){
		Optional<CompanyModel> companyModelOptional = companyService.findById(id);
		if (!companyModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
		}		
		return ResponseEntity.status(HttpStatus.OK).body(companyModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCompany(@PathVariable(value = "id") UUID id){
		Optional<CompanyModel> companyModelOptional = companyService.findById(id);
		if (!companyModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
		}
		companyService.delete(companyModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCompany(@PathVariable(value = "id") UUID id, 
											 @RequestBody @Valid CompanyDto companyDto){
		Optional<CompanyModel> companyModelOptional = companyService.findById(id);
		if (!companyModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
		}
		var companyModel = new CompanyModel();
		BeanUtils.copyProperties(companyDto, companyModel);
		companyModel.setId(companyModelOptional.get().getId());
		companyModel.setDataCriacao(companyModelOptional.get().getDataCriacao());
		return ResponseEntity.status(HttpStatus.OK).body(companyService.save(companyModel));
	}
}
