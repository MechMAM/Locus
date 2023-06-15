package com.api.project.locus.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.project.locus.models.PurposeModel;
import com.api.project.locus.models.ReviewModel;

public interface ReviewRepository extends JpaRepository<ReviewModel, UUID>{

}
