package com.api.project.locus.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

import com.api.project.locus.dtos.BookingDto;
import com.api.project.locus.dtos.auth.ResponseMessage;
import com.api.project.locus.models.BookingModel;
import com.api.project.locus.services.BookingService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping
	public ResponseEntity<Object> saveBooking(@RequestBody @Valid BookingDto bookingDto){
		var bookingModel = new BookingModel();
		bookingService.convertoDtoToEntity(bookingDto, bookingModel);
		bookingService.setDefaults(bookingModel);
		if (bookingService.checkDates(bookingModel.getDataInicio(),bookingModel.getDataFim())) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ResponseMessage("Datas inválidas, tente novamente!"));
		}
		if (!bookingService.checkExistingBookings(bookingModel)) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ResponseMessage("Já existe uma reserva para as datas solicitadas!"));
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.save(bookingModel));
	}
	
	@GetMapping
	public ResponseEntity<List<BookingModel>> getAllBookings(){
		return ResponseEntity.status(HttpStatus.OK).body(bookingService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneBooking(@PathVariable(value = "id") UUID id){
		Optional<BookingModel> BookingModelOptional = bookingService.findById(id);
		if (!BookingModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva não encontrada!");
		}		
		return ResponseEntity.status(HttpStatus.OK).body(BookingModelOptional.get());
	}
	
	@GetMapping("/{id}/{dataInicio}/{dataFim}")
	public ResponseEntity<Object> getBookingsByDate(@PathVariable(value = "id") UUID id, @PathVariable(value = "dataInicio") LocalDateTime dataInicio, @PathVariable(value = "dataFim") LocalDateTime dataFim){
		if (bookingService.checkDates(dataInicio, dataFim)) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ResponseMessage("Datas inválidas, tente novamente!"));
		}
		List<BookingModel> listaReservasEspaco = bookingService.findBySpaceAndDates(id, dataInicio, dataFim);
		return ResponseEntity.status(HttpStatus.OK).body(listaReservasEspaco);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteBooking(@PathVariable(value = "id") UUID id){
		Optional<BookingModel> bookingModelOptional = bookingService.findById(id);
		if (!bookingModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva não encontrada!");
		}
		bookingService.delete(bookingModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Reserva deletada!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateBooking(@PathVariable(value = "id") UUID id, 
											    @RequestBody @Valid BookingDto bookingDto){
		Optional<BookingModel> bookingModelOptional = bookingService.findById(id);
		if (!bookingModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva não encontrada!");
		}
		var bookingModel = new BookingModel();
		bookingService.convertoDtoToEntity(bookingDto, bookingModel);
		if (bookingService.checkDates(bookingModel.getDataInicio(),bookingModel.getDataFim())) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ResponseMessage("Datas inválidas, tente novamente!"));
		}
		if (!bookingService.checkExistingBookings(bookingModel)) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ResponseMessage("Já existe uma reserva para as datas solicitadas!"));
		}
		bookingModel.setId(bookingModelOptional.get().getId());
		bookingModel.setDataModificacao(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.OK).body(bookingService.save(bookingModel));
	}
	
	

}
