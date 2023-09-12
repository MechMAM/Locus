package com.api.project.locus.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;
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
		setUsuario(bookingDto.getUsuarioId(),bookingModel);
		setEspaco(bookingDto.getEspacoId(), bookingModel);
		if (bookingDto.getAvaliacaoId() != null) {
			setAvaliacao(bookingDto.getAvaliacaoId(),bookingModel);
		}
		setPreco(bookingModel);
		bookingModel.setTimeZone(TimeZone.getTimeZone(bookingDto.getTimeZone()));
	}

	private void setPreco(BookingModel bookingModel) {
		SpaceModel espaco = bookingModel.getEspaco();
		double preco = spaceService.evaluatePrice(bookingModel.getDataInicio(), bookingModel.getDataFim(), espaco.getPrecoHorario(), espaco.getTaxaLimpeza());
		bookingModel.setPreco(preco);		
	}

	private void setUsuario(Long usuarioId, BookingModel bookingModel) {
		Optional<UserModel> userModel = userService.findById(usuarioId);
		bookingModel.setUsuario(userModel.get());
	}

	private void setEspaco(UUID espacoId, BookingModel bookingModel) {
		Optional<SpaceModel> spaceModel = spaceService.findById(espacoId);
		bookingModel.setEspaco(spaceModel.get());
	}

	private void setAvaliacao(UUID avaliacaoId, BookingModel bookingModel) {
		Optional<ReviewModel> reviewModel = reviewService.findById(avaliacaoId);
		bookingModel.setAvaliacao(reviewModel.orElse(null));
	}

	public boolean checkDates(BookingModel bookingModel) {
		if (bookingModel.getDataFim().isBefore(bookingModel.getDataInicio()) || bookingModel.getDataInicio().isBefore(LocalDateTime.now())) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean checkExistingBookings(BookingModel bookingModel) {
		List<BookingModel> reservas = bookingRepository.findByDataBetween(bookingModel.getDataInicio(), bookingModel.getDataFim(), bookingModel.getEspaco());
		if (reservas.isEmpty()) {
			return true;			
		} else {
			return false;
		}
		
	}

}
