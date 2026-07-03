package com.pm.backendspringboot.repository;

import com.pm.backendspringboot.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @description Repository for Patient entity. Uses JpaRepository for basic CRUD operations,
 * rely on UUID for the primary key.
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {}
