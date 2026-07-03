package com.pm.backendspringboot.service;


import com.pm.backendspringboot.dto.PatientRequestDTO;
import com.pm.backendspringboot.dto.PatientResponseDto;
import com.pm.backendspringboot.dto.PatientResponseDTOPartial;
import com.pm.backendspringboot.exceptions.EmailAlreadyExistsException;
import com.pm.backendspringboot.exceptions.ResourceNotFoundException;
import com.pm.backendspringboot.mapper.PatientMapper;
import com.pm.backendspringboot.model.Patient;
import com.pm.backendspringboot.repository.PatientRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    /**
     * @description Returns a list of all patients, with only the necessary fields.
     * Including only id, firstName, lastName, email, and active for a more restricted/partial view of the patient.
     * @return List<PatientResponseDTOPartial>
     */
    public List<PatientResponseDTOPartial> getAllPatients(){
        return patientRepository.findAll()
                .stream()
                .map(PatientMapper::toPartialPatientDTO)
                .toList();
    }


    /**
     * @description Returns a list of all patients, with all fields available.
     * @return List<PatientResponseDto>
     */
    public List<PatientResponseDto> getAllPatientsFullInfo(){
        return patientRepository.findAll()
                .stream()
                .map(PatientMapper::toPatientDTO)
                .toList();
    }

    /**
     * @description Returns a single patient, with all fields available.
     * @param id from patient on UUID format
     * @return PatientResponseDto
     */
    public PatientResponseDto getSinglePatient(UUID id) throws BadRequestException {
        return patientRepository.findById(id)
                .map(PatientMapper::toPatientDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Patient with ID " + id + " not fund."));
    }

    /**
     * @description Inserts a new patient into the database.
     * @param patientRequestDTO
     * @return PatientResponseDto
     */
    public PatientResponseDto insertPatient(PatientRequestDTO patientRequestDTO) {

        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("E-mail invalid, value already exists and cannot be duplicated.");
        }

        return PatientMapper.toPatientDTO(//3. Converts the saved patient entity to a PatientResponseDTO
                patientRepository.save(//2. Saves the patient to the database
                        PatientMapper.toPatientEntity(patientRequestDTO))//1. Converts the PatientRequestDTO to a Patient entity
        );
    }
}
