package com.api.project.locus.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.project.locus.models.BookingModel;
import com.api.project.locus.repositories.BookingRepository;

import jakarta.transaction.Transactional;

@Service
public class BookingService {
	
	@Autowired
	BookingRepository bookingRepository;
	
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

}
