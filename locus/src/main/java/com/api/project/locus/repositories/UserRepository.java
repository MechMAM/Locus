package com.api.project.locus.repositories;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.project.locus.models.CompanyModel;
import com.api.project.locus.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {

	Set<CompanyModel> findCompanyModelsById(Long id);

	Optional<UserModel> findByUsername(String username);

	Boolean existsByUsername(String nome);

	Boolean existsByEmail(String email);
}
