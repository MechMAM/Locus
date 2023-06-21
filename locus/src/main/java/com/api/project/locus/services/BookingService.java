package com.api.project.locus.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.project.locus.dtos.BookingDto;
import com.api.project.locus.models.BookingModel;
import com.api.project.locus.models.ReviewModel;
import com.api.project.locus.models.SpaceModel;
import com.api.project.locus.models.UserModel;
import com.api.project.locus.repositories.BookingRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class BookingService {
	
	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	UserService userService;
	@Autowired
	SpaceService spaceService;
	@Autowired
	ReviewService reviewService;
	
	@Transactional
	public BookingModel save(BookingModel bookingModel) {
		return bookingRepository.save(bookingModel);
	}
	
	public List<BookingModel> findAll() {		
		return bookingRepository.findAll();
	}
	
	public Optional<BookingModel> findById(UUID id) {
		return bookingRepository.findById(id);
	}

	@Transactional
	public void delete(BookingModel bookingModel) {
		bookingRepository.delete(bookingModel);;		
	}

	public void setDefaults(BookingModel purposeModel) {
		purposeModel.setDataInclusao(LocalDateTime.now(ZoneId.of("UTC")));
		purposeModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
	}

	public void convertoDtoToEntity(@Valid BookingDto bookingDto, BookingModel bookingModel) {
		BeanUtils.copyProperties(bookingDto, bookingModel);
		Optional<UserModel> userModel = userService.findById(bookingDto.getUsuarioId());
		Optional<SpaceModel> spaceModel = spaceService.findById(bookingDto.getEspacoId());
		Optional<ReviewModel> reviewModel = reviewService.findById(bookingDto.getAvaliacaoId());
		bookingModel.setUsuario(userModel.get());
		bookingModel.setEspaco(spaceModel.get());
		bookingModel.setAvaliacao(reviewModel.orElse(null));
	}

}
