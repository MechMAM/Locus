package com.api.project.locus.controllers;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.project.locus.dtos.ImageDto;
import com.api.project.locus.models.ImageModel;
import com.api.project.locus.services.ImageService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/image")
public class ImageController {
	
	@Autowired
	ImageService imageService;
	
	@PostMapping
	public ResponseEntity<Object> saveImage(@RequestBody @Valid ImageDto imageDto){
		var imageModel = new ImageModel();
		BeanUtils.copyProperties(imageDto, imageModel);
		imageService.setDefaults(imageModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(imageService.save(imageModel));
	}
	
	@GetMapping
	public ResponseEntity<List<ImageModel>> getAllImages(){
		return ResponseEntity.status(HttpStatus.OK).body(imageService.findAll());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneImage(@PathVariable(value = "id") UUID id){
		Optional<ImageModel> ImageModelOptional = imageService.findById(id);
		if (!ImageModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Imagem não encontrada!");
		}		
		return ResponseEntity.status(HttpStatus.OK).body(ImageModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteImage(@PathVariable(value = "id") UUID id){
		Optional<ImageModel> imageModelOptional = imageService.findById(id);
		if (!imageModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Imagem não encontrada!");
		}
		imageService.delete(imageModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Imagem deletada!");
	}
	
}
