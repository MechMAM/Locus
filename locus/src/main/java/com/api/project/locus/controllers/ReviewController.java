package com.api.project.locus.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.project.locus.dtos.ReviewDto;
import com.api.project.locus.models.ReviewModel;
import com.api.project.locus.services.ReviewService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/review")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	@PostMapping
	public ResponseEntity<Object> saveReview(@RequestBody @Valid ReviewDto reviewDto){
		var reviewModel = new ReviewModel();
		BeanUtils.copyProperties(reviewDto, reviewModel);
		reviewService.setDefaults(reviewModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.save(reviewModel));
	}
	
	@GetMapping
	public ResponseEntity<List<ReviewModel>> getAllReviews(){
		return ResponseEntity.status(HttpStatus.OK).body(reviewService.findAll());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneReview(@PathVariable(value = "id") UUID id){
		Optional<ReviewModel> ReviewModelOptional = reviewService.findById(id);
		if (!ReviewModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Avaliação não encontrada!");
		}		
		return ResponseEntity.status(HttpStatus.OK).body(ReviewModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteReview(@PathVariable(value = "id") UUID id){
		Optional<ReviewModel> reviewModelOptional = reviewService.findById(id);
		if (!reviewModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Avaliação não encontrada!");
		}
		reviewService.delete(reviewModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Avaliação deletada!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateReview(@PathVariable(value = "id") UUID id, 
											    @RequestBody @Valid ReviewDto reviewDto){
		Optional<ReviewModel> reviewModelOptional = reviewService.findById(id);
		if (!reviewModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Avaliação não encontrada!");
		}
		var reviewModel = new ReviewModel();
		BeanUtils.copyProperties(reviewDto, reviewModel);
		reviewModel.setId(reviewModelOptional.get().getId());
		reviewModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.OK).body(reviewService.save(reviewModel));
	}
	
	

}
