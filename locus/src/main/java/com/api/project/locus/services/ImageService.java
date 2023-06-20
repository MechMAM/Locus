package com.api.project.locus.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.project.locus.dtos.ImageDto;
import com.api.project.locus.models.ImageModel;
import com.api.project.locus.models.SpaceModel;
import com.api.project.locus.repositories.ImageRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class ImageService {
	
	@Autowired
	ImageRepository imageRepository;
	@Autowired
	SpaceService spaceService;
	
	@Transactional
	public ImageModel save(ImageModel imageModel) {
		return imageRepository.save(imageModel);
	}
	
	public List<ImageModel> findAll() {		
		return imageRepository.findAll();
	}
	
	public Optional<ImageModel> findById(UUID id) {
		return imageRepository.findById(id);
	}

	@Transactional
	public void delete(ImageModel imageModel) {
		imageRepository.delete(imageModel);;		
	}

	public void setDefaults(ImageModel imageModel) {
		imageModel.setDataInclusao(LocalDateTime.now(ZoneId.of("UTC")));
	}

	public void convertDtoToEntity(@Valid ImageDto imageDto, ImageModel imageModel) {
		BeanUtils.copyProperties(imageDto, imageModel);
		Optional<SpaceModel> spaceModel = spaceService.findById(imageDto.getEspacoId());
		imageModel.setEspaco(spaceModel.get());
	}

}
