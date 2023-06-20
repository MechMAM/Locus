package com.api.project.locus.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.project.locus.dtos.ChargingMethodDto;
import com.api.project.locus.models.ChargingMethodModel;
import com.api.project.locus.models.InvoiceModel;
import com.api.project.locus.repositories.ChargingMethodRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class ChargingMethodService {
	
	@Autowired
	ChargingMethodRepository chargingMethodRepository;
	@Autowired
	InvoiceService invoiceService;
	
	@Transactional
	public ChargingMethodModel save(ChargingMethodModel chargingMethodModel) {
		return chargingMethodRepository.save(chargingMethodModel);
	}
	
	public List<ChargingMethodModel> findAll() {		
		return chargingMethodRepository.findAll();
	}
	
	public Optional<ChargingMethodModel> findById(UUID id) {
		return chargingMethodRepository.findById(id);
	}

	@Transactional
	public void delete(ChargingMethodModel chargingMethodModel) {
		chargingMethodRepository.delete(chargingMethodModel);;		
	}

	public void setDefaults(ChargingMethodModel purposeModel) {
		purposeModel.setDataInclusao(LocalDateTime.now(ZoneId.of("UTC")));
		purposeModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
	}

	public void convertDtoToEntity(@Valid ChargingMethodDto chargingMethodDto,
			ChargingMethodModel chargingMethodModel) {
		BeanUtils.copyProperties(chargingMethodDto, chargingMethodModel);
		Optional<InvoiceModel> invoiceModel = invoiceService.findById(chargingMethodDto.getTituloId());
		chargingMethodModel.setTitulo(invoiceModel.get());
	}

}
