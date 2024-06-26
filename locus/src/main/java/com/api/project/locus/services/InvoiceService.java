package com.api.project.locus.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.project.locus.dtos.InvoiceDto;
import com.api.project.locus.models.BookingModel;
import com.api.project.locus.models.InvoiceModel;
import com.api.project.locus.repositories.InvoiceRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class InvoiceService {
	
	@Autowired
	InvoiceRepository invoiceRepository;
	@Autowired
	BookingService bookingService;
	
	@Transactional
	public InvoiceModel save(InvoiceModel invoiceModel) {
		return invoiceRepository.save(invoiceModel);
	}
	
	public List<InvoiceModel> findAll() {		
		return invoiceRepository.findAll();
	}
	
	public Optional<InvoiceModel> findById(UUID id) {
		return invoiceRepository.findById(id);
	}

	@Transactional
	public void delete(InvoiceModel invoiceModel) {
		invoiceRepository.delete(invoiceModel);;		
	}

	public void setDefaults(InvoiceModel purposeModel) {
		purposeModel.setDataInclusao(LocalDateTime.now(ZoneId.of("UTC")));
		purposeModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
	}

	public void convertDtoToEntity(@Valid InvoiceDto invoiceDto, InvoiceModel invoiceModel) {
		BeanUtils.copyProperties(invoiceDto, invoiceModel);
		Optional<BookingModel> bookingModel = bookingService.findById(invoiceDto.getReservaId());
		invoiceModel.setReserva(bookingModel.get());
	}

}
