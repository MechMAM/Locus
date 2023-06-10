package com.api.project.locus.repositories;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.project.locus.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{
	
	Set<UserModel> findUserModelsByCompanyModels(UUID id);	
}
