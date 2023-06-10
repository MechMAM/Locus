package com.api.project.locus.repositories;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.project.locus.models.CompanyModel;

public interface CompanyRepository extends JpaRepository<CompanyModel, UUID>{
	
	Set<CompanyModel> findCompanysModelsByUserModels(Long id);
}
