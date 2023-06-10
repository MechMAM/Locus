package com.api.project.locus.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.project.locus.models.CompanyModel;
import com.api.project.locus.repositories.CompanyRepository;

import jakarta.transaction.Transactional;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository companyRepository;

	@Transactional
	public CompanyModel save(CompanyModel userModel) {
		return companyRepository.save(userModel);
	}
	
	public String cleanCnpj(String cnpj) {
        if (cnpj.length() > 14) {
        	cnpj = cnpj.trim().replaceAll("\\D", "");
        }
        return cnpj;
	}
	
	public Page<CompanyModel> findAll(Pageable pageable) {		
		return companyRepository.findAll(pageable);
	}
	
	public Optional<CompanyModel> findById(UUID id) {
		return companyRepository.findById(id);
	}

	@Transactional
	public void delete(CompanyModel userModel) {
		companyRepository.delete(userModel);;		
	}

	
	

}
