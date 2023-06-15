package com.api.project.locus.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.project.locus.models.BookingModel;

public interface BookingRepository extends JpaRepository<BookingModel, UUID>{

}
