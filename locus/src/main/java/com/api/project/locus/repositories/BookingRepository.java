package com.api.project.locus.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.project.locus.models.BookingModel;

public interface BookingRepository extends JpaRepository<BookingModel, UUID>{
	
//	  @Query("SELECT id, data_inicio, data_fim FROM reserva B WHERE B.data_inicio BETWEEN ?1 AND ?2")
//	  List<BookingModel> findByDateBetween(LocalDateTime dataInicio, LocalDateTime dataFim);

}
