package com.api.project.locus.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.project.locus.models.AccessibilityModel;

public interface AccessibilityRepository extends JpaRepository<AccessibilityModel, UUID>{

}
