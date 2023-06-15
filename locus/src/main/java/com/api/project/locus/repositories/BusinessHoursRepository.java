package com.api.project.locus.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.project.locus.models.BusinessHoursModel;

public interface BusinessHoursRepository extends JpaRepository<BusinessHoursModel, UUID>{

}
