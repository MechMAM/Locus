package com.api.project.locus.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.project.locus.models.InvoiceModel;

public interface InvoiceRepository extends JpaRepository<InvoiceModel, UUID>{

}
