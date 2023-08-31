package com.api.project.locus.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.project.locus.models.BookingModel;
import com.api.project.locus.models.SpaceModel;

public interface BookingRepository extends JpaRepository<BookingModel, UUID>{
	
	
	  @Query("SELECT id, dataInicio, dataFim FROM BookingModel B WHERE ((B.dataInicio BETWEEN ?1 AND ?2) OR (B.dataFim BETWEEN ?1 AND ?2) AND B.espaco = ?3)")
	  List<BookingModel> findByDataBetween(LocalDateTime dataInicio, LocalDateTime dataFim, SpaceModel espaco);
	  
}
