package com.api.project.locus.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.project.locus.models.ReviewModel;
import com.api.project.locus.repositories.ReviewRepository;

import jakarta.transaction.Transactional;

@Service
public class ReviewService {
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@Transactional
	public ReviewModel save(ReviewModel reviewModel) {
		return reviewRepository.save(reviewModel);
	}
	
	public List<ReviewModel> findAll() {		
		return reviewRepository.findAll();
	}
	
	public Optional<ReviewModel> findById(UUID id) {
		return reviewRepository.findById(id);
	}

	@Transactional
	public void delete(ReviewModel reviewModel) {
		reviewRepository.delete(reviewModel);;		
	}

	public void setDefaults(ReviewModel purposeModel) {
		purposeModel.setDataInclusao(LocalDateTime.now(ZoneId.of("UTC")));
		purposeModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
	}

}
