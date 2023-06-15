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

import com.api.project.locus.dtos.InvoiceDto;
import com.api.project.locus.models.InvoiceModel;
import com.api.project.locus.services.InvoiceService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/invoice")
public class InvoiceController {
	
	@Autowired
	InvoiceService invoiceService;
	
	@PostMapping
	public ResponseEntity<Object> saveInvoice(@RequestBody @Valid InvoiceDto invoiceDto){
		var invoiceModel = new InvoiceModel();
		BeanUtils.copyProperties(invoiceDto, invoiceModel);
		invoiceService.setDefaults(invoiceModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(invoiceService.save(invoiceModel));
	}
	
	@GetMapping
	public ResponseEntity<List<InvoiceModel>> getAllInvoices(){
		return ResponseEntity.status(HttpStatus.OK).body(invoiceService.findAll());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneInvoice(@PathVariable(value = "id") UUID id){
		Optional<InvoiceModel> InvoiceModelOptional = invoiceService.findById(id);
		if (!InvoiceModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Título não encontrado!");
		}		
		return ResponseEntity.status(HttpStatus.OK).body(InvoiceModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteInvoice(@PathVariable(value = "id") UUID id){
		Optional<InvoiceModel> invoiceModelOptional = invoiceService.findById(id);
		if (!invoiceModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Título não encontrado!");
		}
		invoiceService.delete(invoiceModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Título deletado!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateInvoice(@PathVariable(value = "id") UUID id, 
											    @RequestBody @Valid InvoiceDto invoiceDto){
		Optional<InvoiceModel> invoiceModelOptional = invoiceService.findById(id);
		if (!invoiceModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Título não encontrado!");
		}
		var invoiceModel = new InvoiceModel();
		BeanUtils.copyProperties(invoiceDto, invoiceModel);
		invoiceModel.setId(invoiceModelOptional.get().getId());
		invoiceModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.OK).body(invoiceService.save(invoiceModel));
	}
	
	

}
