package com.api.project.locus.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.project.locus.models.AddressModel;
import com.api.project.locus.repositories.AddressRepository;

import jakarta.transaction.Transactional;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	@Transactional
	public AddressModel save(AddressModel addressModel) {
		return addressRepository.save(addressModel);
	}
	
	public List<AddressModel> findAll() {		
		return addressRepository.findAll();
	}
	
	public Optional<AddressModel> findById(UUID id) {
		return addressRepository.findById(id);
	}

	@Transactional
	public void delete(AddressModel addressModel) {
		addressRepository.delete(addressModel);;		
	}

	public void setDefaults(AddressModel addressModel) {
		addressModel.setDataInclusao(LocalDateTime.now(ZoneId.of("UTC")));
		addressModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
	}

}
