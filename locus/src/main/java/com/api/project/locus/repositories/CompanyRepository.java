package com.api.project.locus.repositories;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.project.locus.models.CompanyModel;
import com.api.project.locus.models.UserModel;

public interface CompanyRepository extends JpaRepository<CompanyModel, UUID>{
	
	Set<UserModel> findUserModelsById(UUID id);
}
