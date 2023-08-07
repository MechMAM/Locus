package com.api.project.locus.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.project.locus.models.AccessTypeModel;
import com.api.project.locus.models.enums.AccessTypeEnum;

public interface AccessTypeRepository extends JpaRepository<AccessTypeModel, UUID> {

	Optional<AccessTypeModel> findByNomeFuncao(AccessTypeEnum nomeFuncao);

}
